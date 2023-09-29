package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
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

        Post newPost = new Post(postDto.getId(), postDate, postDto.getCategory(), user, product, postDto.getPrice(), postDto.getHasPromo(), postDto.getDiscount());

        if (postRepository.save(newPost) == null)
            throw new AlreadyExistsException("El producto con id " + product.getId() + " ya existe");
    }

    private Product mapProduct(ProductDto productDto) {

        return new Product(productDto.getId(), productDto.getName(), productDto.getType(), productDto.getBrand(), productDto.getColor(), productDto.getNotes());
    }

    private User getUser(int id) {
        User user = userRepository.findUsersById(id);

        if (user == null) throw new NotFoundException("El usuario " + id +  " no existe");
        return user;
    }


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
    public void saveNewPromotion(PostDto postDto) {
        User user = findUserById(postDto.getUserId());
        Product existingProduct = findProductById(postDto.getProduct().getId());


        LocalDate postDate = parsePostDate(postDto.getDate());
        Post newPromotion = createNewPromotion(postDto.getId(), postDate, postDto.getCategory(), user,
                existingProduct, postDto.getPrice(), postDto.getHasPromo(), postDto.getDiscount());

        if (postRepository.save(newPromotion) == null) {
            System.out.println("El producto con id " + existingProduct.getId() + " ya existe");
        }
    }

    private List<PostDto> orderList(List<Post> posts, boolean isAsc) {
        return posts.stream()
                .filter(Objects::nonNull).sorted((x, y) -> isAsc ? x.getDate().compareTo(y.getDate()) : y.getDate().compareTo(x.getDate()))
                .map(postMapper::toPostDTO)
                .collect(Collectors.toList());
    }

    private User findUserById(int userId) {
        return userRepository.findUsersById(userId);
    }

    private Product findProductById(int productId) {
        return postRepository.findPostById(productId).getProduct();
    }

    private LocalDate parsePostDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    private Post createNewPromotion(int id, LocalDate postDate, int category, User user, Product product, double price, boolean hasPromo, double discount) {
        return new Post(id, postDate, category, user, product, price, hasPromo, discount);
    }
}