package com.w22_g03.be_java_hisp_w22_g03_bayarri.service;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.*;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.Post;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.Product;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.User;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private UserService userService;

    @Override
    public PostDTO addPost(PostDTO postDTO) {

        User user = userService.findById(postDTO.getUserId());

        Post post = toPost(postDTO, user);
        post.setPostId(this.postRepository.countPosts() + 1);
        postDTO.setPostId(post.getPostId());

        this.postRepository.savePost(post);
        return postDTO;
    }

    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId) {
        return this.getFollowedUsersPostsById(userId, "date_desc");
    }

    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order) {
        UserFollowedSellersPostsDTO postsDto = getAllFollowedUsersPostsById(userId);
        postsDto.setPosts(sortByDate(order, postsDto.getPosts()));
        return postsDto;
    }

    @Override
    public NumberOfPromoPostDTO countPromoPostBySeller(long userId) {
        User user = userService.findById(userId);
        return NumberOfPromoPostDTO.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .quantity(user.getPosts().stream()
                        .filter(Post::isHasPromo)
                        .count()
                )
                .build();
    }

    @Override
    public PromoPostByUserDTO getPromoPostBySeller(long userId) {
        User user = userService.findById(userId);
        PromoPostByUserDTO promoPostByUserDTO = new PromoPostByUserDTO();
        promoPostByUserDTO.setUserId(userId);
        promoPostByUserDTO.setUsername(user.getUsername());
        promoPostByUserDTO.setPosts(postRepository.findPromoPostByUser(user).stream().map(this::toPromoPostDTO).toList());
        return promoPostByUserDTO;
    }

    private UserFollowedSellersPostsDTO getAllFollowedUsersPostsById(long userId) {
        User user = userService.findById(userId);
        List<Post> twoWeekOldPostsBySeller = postRepository.findTwoWeekOldPostsFromFollowedByUser(user);
        return toUserFollowedSellersPostsDTO(twoWeekOldPostsBySeller, userId);
    }

    private UserFollowedSellersPostsDTO toUserFollowedSellersPostsDTO(List<Post> twoWeekOldPostsBySeller, long userId) {
        UserFollowedSellersPostsDTO userFollowedSellersPostsDTO = new UserFollowedSellersPostsDTO();

        userFollowedSellersPostsDTO.setUserId(userId);
        userFollowedSellersPostsDTO.setPosts(
                twoWeekOldPostsBySeller.stream()
                        .map(this::toPostDTO)
                        .toList());

        return userFollowedSellersPostsDTO;
    }


    private List<PostDTO> sortByDate(String order, List<PostDTO> postsDto) {
        if (order.equals("date_asc")) {
            return postsDto.stream().sorted(Comparator.comparing(PostDTO::getDate)).toList();
        } else {
            return postsDto.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList();
        }
    }

    private Post toPost(PostDTO postDTO, User user) {
        ModelMapper mapper = new ModelMapper();
        Post post = mapper.map(postDTO, Post.class);
        Product product = mapper.map(postDTO.getProduct(), Product.class);
        product.setPost(post);
        post.setProduct(product);
        post.setUser(user);
        return post;
    }

    private PostDTO toPostDTO(Post post) {
        ModelMapper mapper = new ModelMapper();
        PostDTO postDto = mapper.map(post, PostDTO.class);
        postDto.setProduct(mapper.map(post.getProduct(), ProductDTO.class));
        postDto.setUserId(post.getUser().getUserId());
        return postDto;
    }

    private PostDTO toPromoPostDTO(Post post) {
        ModelMapper mapper = new ModelMapper();
        PostDTO postDto = mapper.map(post, PromoPostDTO.class);
        postDto.setProduct(mapper.map(post.getProduct(), ProductDTO.class));
        postDto.setUserId(post.getUser().getUserId());
        return postDto;
    }

}
