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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final PostMapper postMapper;


    @Override
    public void saveNewPost(PostDto postDto) {
        Post newPost = createNewPost(postDto);
        if (postRepository.save(newPost) == null)
            throw new AlreadyExistsException("El producto con id " + postDto.getProduct().getId() + " ya existe");
    }

    @Override
    public void saveNewPostPromo(PostPromoDto postPromoDto) {
        Post newPost = createNewPost(postPromoDto);
        newPost.setHasPromo(postPromoDto.getHasPromo());
        newPost.setDiscount(postPromoDto.getDiscount());
        if (postRepository.save(newPost) == null)
            throw new AlreadyExistsException("El producto con id " + postPromoDto.getProduct().getId() + " ya existe");

    }

    private Post createNewPost(PostDto post) {
        User user = getUser(post.getUserId());
        Product product = mapProduct(post.getProduct());
        LocalDate postDate = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return Post.builder()
                .id(post.getId())
                .date(postDate)
                .category(post.getCategory())
                .user(user)
                .product(product)
                .price(post.getPrice())
                .build();
    }

    private Product mapProduct(ProductDto productDto) {

        return new Product(productDto.getId(), productDto.getName(), productDto.getType(), productDto.getBrand(), productDto.getColor(), productDto.getNotes());
    }

    private User getUser(int id) {
        User user = userRepository.findUsersById(id);

        if (user == null) throw new NotFoundException("El usuario " + id + " no existe");
        return user;
    }


    public List<PostDto> getListPostsFromSellersFollowed(int userId, String order) {
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
        return orderList(postList, order != null && order.equals("date_asc"));

    }

    @Override
    public PostPromoCountDto getNumberPromotions(int userId) {
        User user = userRepository.findUsersById(userId);
        if (user == null) {
            throw new NotFoundException("Usuario " + userId + " no encontrado");
        }
        int promotionsCount = (int) postRepository.findPostByUserId(userId)
                .stream()
                .filter(Post::isHasPromo)
                .count();

        return new PostPromoCountDto(userId, user.getName(), promotionsCount);
    }

    @Override
    public PostPromotionsDto getPromotions(int userId) {
        User user = userRepository.findUsersById(userId);
        if (user == null) {
            throw new NotFoundException("No se encontró el usuario " + userId);
        }
        List<PostPromoDto> promotions = postRepository.findPostByUserId(userId)
                .stream()
                .filter(Post::isHasPromo)
                .map(postMapper::toPostPromoDTO)
                .toList();

        return new PostPromotionsDto(userId, user.getName(), promotions);
    }

    private List<PostDto> orderList(List<Post> posts, boolean isAsc) {
        return posts.stream()
                .filter(Objects::nonNull).sorted((x, y) -> isAsc ? x.getDate().compareTo(y.getDate()) : y.getDate().compareTo(x.getDate()))
                .map(postMapper::toPostDTO)
                .toList();
    }

}
