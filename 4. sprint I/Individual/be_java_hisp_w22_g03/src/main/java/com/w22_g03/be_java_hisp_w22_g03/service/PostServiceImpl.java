package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.*;
import com.w22_g03.be_java_hisp_w22_g03.exception.BadRequestException;
import com.w22_g03.be_java_hisp_w22_g03.exception.NotFoundException;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepository;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.prefs.BackingStoreException;
import java.util.stream.Collectors;

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
        if(!postDTO.isHasPromo() && postDTO.getDiscount()!=0.0)
            throw new BadRequestException("It can't be a post with a discount but with no promo");
        else if(postDTO.isHasPromo() && postDTO.getDiscount() == 0.0 || postDTO.getDiscount() < 0)
            throw new BadRequestException("It can not be a post with a promo but with no discount");
        else

        this.postRepository.savePost(post);
        postDTO.setPostId(post.getPostId());
        return postDTO;

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
    public NumbersOfPromosDTO countPostsWithDiscounts(long id) {

        NumbersOfPromosDTO responseDto = new NumbersOfPromosDTO();
        User user = userService.findById(id);
        if(postRepository.countPostsWithDiscounts(id)!=0){
            responseDto.setUser_id(user.getUserId());
            responseDto.setUser_name(user.getUsername());
            responseDto.setPromo_products_count(postRepository.countPostsWithDiscounts(id));

            return responseDto;
        } else {
            throw new NotFoundException("This user currently has no promo in his products");
        }

    }

    @Override
    public ProductsInPromoDTO getPostsInPromo(long userId) {

        ProductsInPromoDTO responseDto = new ProductsInPromoDTO();
        User myUser = userService.findById(userId);

        if(myUser==null) throw new NotFoundException("There is no User with this id");

        responseDto.setUser_id(myUser.getUserId());
        responseDto.setUser_name(myUser.getUsername());

        List<PostDTO> myPostsWithDiscount = postRepository.getPostsWithPromos(userId).stream().map(this::mapPostToPostDto).toList();
        if(myPostsWithDiscount.isEmpty()) throw new NotFoundException("At the moment, there are no posts from this user with a valid promotion.");

        responseDto.setPosts(myPostsWithDiscount);

        return responseDto;
    }
}
