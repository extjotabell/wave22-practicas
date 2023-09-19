package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IProductService productService;
    private final IUserService userService;
    private final ObjectMapper objectMapper;

    @Override
    public List<DiscountedPostDto> getAllPosts() {
        List<Post> postList = postRepository.getAllPost();
        if (postList.isEmpty()) throw new NotFoundException("No se encontraron posts en el sistema.");

        return postList.stream().map(post ->
        {
            ProductDto product = productService.getProductById(post.getProduct_id());
            DiscountedPostDto postDto = objectMapper.convertValue(post, DiscountedPostDto.class);
            postDto.setProduct(product);
            return postDto;
        }).collect(Collectors.toList());
    }


    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order) {
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowed();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(idUser -> {
            List<Post> postList = postRepository.getLatestPostsByUserId(idUser);

            postList.forEach(post -> {
                ProductDto productDto = productService.getProductById(post.getProduct_id());
                PostDto postDto = this.objectMapper.convertValue(post, PostDto.class);
                postDto.setProduct(productDto);
                postDtoList.add(postDto);
            });
        });

        if(order == ProductOrderListEnum.date_desc) {
            return new FollowedPostListDto(
                    userId, postDtoList.stream().sorted((date1, date2) -> date2.getDate().compareTo(date1.getDate())).
                    collect(Collectors.toList()));
        }

        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted(Comparator.comparing(PostDto::getDate)).
                collect(Collectors.toList()));
    }

    @Override
    public String addPost(PostDto postDto) {
        int idNewPost;
        Post post = objectMapper.convertValue(postDto, Post.class);
        User postOwner = userService.findUserById(post.getUser_id());
        post.setProduct_id(postDto.getProduct().getProduct_id());
        idNewPost = postRepository.addPost(post);
        productService.addProducto(postDto.getProduct());
        userService.addPostToUser(postOwner, idNewPost);

        return "Se agrego exitosamente un nuevo post con el numero : " + idNewPost;
        //Returning the sorted list ordered by the latest post
    }

    @Override
    public PromoCountDto getPostInPromoByUser(Integer userId) {
        String userName = this.userService.getUserName(userId);
        Integer promoCount = this.postRepository.getPromoCountByUserId(userId);

        if (promoCount == 0) {
            throw new NotFoundException(
                    String.format("El usuario %s con ID %d no tiene promociones asociadas", userName, userId)
            );
        }

        return new PromoCountDto(userId, userName, promoCount);
    }

    @Override
    public PromoPostsByUserDto getPostListInPromoByUser(Integer userId) {
        String userName = this.userService.getUserName(userId);
        List<Post> postList = this.postRepository.getPromoPostsByUser(userId);

        if (postList.isEmpty()) {
            throw new NotFoundException(
                    String.format("El usuario %s con ID %d no tiene promociones asociadas", userName, userId)
            );
        }

        List<PostDto> postDtoList = postList
                .stream()
                .map(post -> {
                    PostDto postDto = objectMapper.convertValue(post, DiscountedPostDto.class);
                    postDto.setProduct(this.productService.getProductById(post.getProduct_id()));
                    return postDto;
                })
                .toList();

        return new PromoPostsByUserDto(userId, userName, postDtoList);
    }
}
