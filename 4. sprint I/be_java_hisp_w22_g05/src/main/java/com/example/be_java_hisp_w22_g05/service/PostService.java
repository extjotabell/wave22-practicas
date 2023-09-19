package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.*;
import com.example.be_java_hisp_w22_g05.entity.Post;
import com.example.be_java_hisp_w22_g05.entity.Product;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.example.be_java_hisp_w22_g05.exception.AlreadyExistsException;
import com.example.be_java_hisp_w22_g05.exception.NotFoundException;
import com.example.be_java_hisp_w22_g05.mapper.PostMapper;
import com.example.be_java_hisp_w22_g05.repository.IPostRepository;
import com.example.be_java_hisp_w22_g05.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final PostMapper postMapper;

    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;


    @Override
    public void saveNewPost(PostDto postDto) {
        User user = getUser(postDto.getUserId());

        Product product = mapProduct(postDto.getProduct());

        LocalDate postDate = LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        ModelMapper mapper = new ModelMapper();

        boolean hasPromo = (postDto.getHasPromo() != null) ? postDto.getHasPromo() : false;
        Double discount = (postDto.getHasPromo() != null) ? postDto.getDiscount() : 0.0;

        Post newPost = new Post(postDto.getId(), postDate, postDto.getCategory(),
                user, product, postDto.getPrice(), hasPromo, discount);

        if (postRepository.save(newPost) == null) {
            throw new AlreadyExistsException("El producto con id " + product.getId() + " ya existe");
        }
    }


    private Product mapProduct(ProductDto productDto) {

        return new Product(productDto.getId(), productDto.getName(), productDto.getType(), productDto.getBrand(), productDto.getColor(), productDto.getNotes());
    }

    private User getUser(int id) {
        User user = userRepository.findUsersById(id);

        if (user == null) throw new NotFoundException("El usuario " + id +  " no existe");
        return user;
    }


    @Override
    public List<PostDto> getListPostsFromSellersFollowed(int userId, String order) {

        ObjectMapper objectMapper = mapperBuilder.build();

        // Obtain list of sellers followed
        List<User> sellersList = userRepository.findUsersById(userId).getFollowed();

        // Obtain list of id from sellers
        List<Integer> sellersId = sellersList.stream()
                .map(User::getId)
                .toList();

        // Obtain list of posts from sellers
        List<Post> postList = postRepository.findPostAll().stream()
                .filter(x -> ChronoUnit.DAYS.between(x.getDate(), LocalDate.now()) <= 14)
                .filter(post -> sellersId.contains(post.getUser().getId()))
                .toList();

        if (postList.isEmpty()) {
            throw new NotFoundException("No se encontró ningún post");
        }

        //Aca ordenamos
        if (order != null && order.equals("date_asc")) {
            return orderList(postList, true);
        } else {
            return orderList(postList, false);
        }

    }

    @Override
    public PostPromoCountDto findQuantityProductsPromoBySeller(int userId) {
        // Buscar al usuario por su ID
        User user = userRepository.findUsersById(userId);

        if (user == null) {
            throw new NotFoundException("No se encontró el usuario " + userId);
        }

        // Obtener todas las publicaciones
        List<Post> postList = postRepository.findPostAll();


        // Filtrar las publicaciones del usuario
        List<Post> sellerPosts = postList.stream()
                .filter(post -> post.getUser().equals(user))
                .toList();
        
        if (sellerPosts.isEmpty()) {
            throw new NotFoundException("No se encontró ningún post del usuario " + userId);
        }
        // Contar la cantidad de productos en promoción
        int promoProductCount = Math.toIntExact(sellerPosts.stream()
                .filter(Post::getHasPromo)
                .count());

        // Crear y devolver un objeto PostPromoDto con la cantidad
        return new PostPromoCountDto(user.getId(),user.getName(), promoProductCount);
    }

    @Override
    public UserPostPromoDto findListProductPromoSeller(int userId) {
        // Buscar al usuario por su ID
        User user = userRepository.findUsersById(userId);
        if (user == null) {
            throw new NotFoundException("No se encontró el usuario " + userId);
        }
        //obtener y formatear las publicaciones del usuario
        List<PostDto> postDtos = getFormattedPostDtosForUser(user);

        if (postDtos.isEmpty()) {
            throw new NotFoundException("No se encontró ningún post del usuario " + userId);
        }

        return new UserPostPromoDto(user.getId(), user.getName(), postDtos);
    }

    @Override
    public List<PostDto> findPostAll() {
        List<Post> postList = postRepository.findPostAll();
        return postList.stream()
                .map(this::mapPostToPostDto)
                .collect(Collectors.toList());
    }

    private List<PostDto> orderList(List<Post> posts, boolean isAsc) {
        return posts.stream()
                .filter(Objects::nonNull).sorted((x, y) -> isAsc ? x.getDate().compareTo(y.getDate()) : y.getDate().compareTo(x.getDate()))
                .map(postMapper::toPostDTO)
                .collect(Collectors.toList());
    }

    private List<PostDto> getFormattedPostDtosForUser(User user) {
        List<Post> postList = postRepository.findPostAll();

        return postList.stream()
                .filter(post -> post.getUser().equals(user))
                .map(this::mapPostToPostDto)
                .collect(Collectors.toList());
    }

    //convierte una instancia de Post en un PostDto
    private PostDto mapPostToPostDto(Post post) {
        String formattedDate = post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Product product = post.getProduct();
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );

        return new PostDto(
                post.getId(),
                post.getUser().getId(),
                formattedDate,
                productDto,
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }




}
