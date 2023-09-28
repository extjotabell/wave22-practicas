package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.*;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepository;
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

        Post post = mapPostDtoToPost(postDTO, user);
        post.setPostId(this.postRepository.countPosts() + 1);

        this.postRepository.savePost(post);
        postDTO.setPostId(post.getPostId());
        return postDTO;
    }

    @Override
    public PostWithPromoDTO addPostWithPromotion(PostWithPromoDTO postWithPromoDTO) {
        PostDTO addedPost = this.addPost(postWithPromoDTO);

        postWithPromoDTO.setPostId(addedPost.getPostId());
        return postWithPromoDTO;
    }



    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId) {
        return this.getFollowedUsersPostsById(userId, "date_desc");
    }

    public UserFollowedSellersPostsDTO getAllFollowedUsersPostsById(long userId) {
        User user = userService.findById(userId);
        List<Post> twoWeekOldPostsBySeller = postRepository.findTwoWeekOldPostsFromFollowedByUser(user);

        return mapPostsToUserFollowedSellersPostsDto(twoWeekOldPostsBySeller, userId);
    }

    private UserFollowedSellersPostsDTO mapPostsToUserFollowedSellersPostsDto(List<Post> twoWeekOldPostsBySeller, long userId) {
        UserFollowedSellersPostsDTO userFollowedSellersPostsDTO = new UserFollowedSellersPostsDTO();

        userFollowedSellersPostsDTO.setUserId(userId);
        userFollowedSellersPostsDTO.setPosts(
                twoWeekOldPostsBySeller.stream()
                .map(this::mapPostToPostDto)
                .toList());

        return userFollowedSellersPostsDTO;
    }

    private Post mapPostDtoToPost(PostDTO postDTO, User user) {
        ModelMapper mapper = new ModelMapper();
        Post post = mapper.map(postDTO, Post.class);
        post.setProduct(mapper.map(postDTO.getProduct(), Product.class));
        post.setUser(user);
        return post;
    }

    private  PostDTO mapPostToPostDto(Post post) {
        ModelMapper mapper = new ModelMapper();
        PostDTO postDto = mapper.map(post, PostDTO.class);
        postDto.setProduct(mapper.map(post.getProduct(), ProductDTO.class));
        postDto.setUserId(post.getUser().getUserId());
        return postDto;
    }

    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order) {
        UserFollowedSellersPostsDTO postsDto = getAllFollowedUsersPostsById(userId);

        postsDto.setPosts(sortByDate(order, postsDto.getPosts()));

        return postsDto;
    }

    private List<PostDTO> sortByDate(String order, List<PostDTO> postsDto) {
        if(order.equals("date_asc")){
            return postsDto.stream().sorted(Comparator.comparing(PostDTO::getDate)).toList();
        }else{
            return postsDto.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList();
        }
    }

    @Override
    public SellerPromotionsCountDTO getSellerPromotionsCount(long sellerId) {
        SellerPromotionsCountDTO sellerPromotionsCountDto = new SellerPromotionsCountDTO();
        User seller = this.userService.findById(sellerId);

        sellerPromotionsCountDto.setUserId(sellerId);
        sellerPromotionsCountDto.setUsername(seller.getUsername());
        sellerPromotionsCountDto.setPromoProductsCount(this.postRepository.countPromotionPostsBySeller(seller));

        return sellerPromotionsCountDto;
    }

    @Override
    public SellerPromotionsDTO getSellerPromotions(long sellerId) {
        SellerPromotionsDTO sellerPromotionsDto = new SellerPromotionsDTO();
        User seller = this.userService.findById(sellerId);

        sellerPromotionsDto.setUserId(sellerId);
        sellerPromotionsDto.setUsername(seller.getUsername());
        sellerPromotionsDto.setPosts(this.postRepository.findPromotionPostsBySeller(seller)
                .stream()
                .map(this::mapPostToPostWithPromoDTO)
                .toList());

        return sellerPromotionsDto;
    }

    private PostWithPromoDTO mapPostToPostWithPromoDTO(Post post) {
        ModelMapper mapper = new ModelMapper();
        PostWithPromoDTO postWithPromoDto = mapper.map(post, PostWithPromoDTO.class);
        postWithPromoDto.setProduct(mapper.map(post.getProduct(), ProductDTO.class));
        return postWithPromoDto;
    }
}