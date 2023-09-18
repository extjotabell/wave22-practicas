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

    public UserFollowedSellersPostsDTO getAllFollowedUsersPostsById(long userId) {
        User user = userService.findById(userId);
        List<Post> twoWeekOldPostsBySeller = postRepository.findTwoWeekOldPostsFromFollowedByUser(user);
        return toUserFollowedSellersPostsDTO(twoWeekOldPostsBySeller, userId);
    }

    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order) {
        UserFollowedSellersPostsDTO postsDto = getAllFollowedUsersPostsById(userId);
        postsDto.setPosts(sortByDate(order, postsDto.getPosts()));
        return postsDto;
    }

    private UserFollowedSellersPostsDTO mapPostsToUserFollowedSellersPostsDto(List<Post> twoWeekOldPostsBySeller, long userId) {
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
        post.setProduct(mapper.map(postDTO.getProduct(), Product.class));
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

    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order) {
        UserFollowedSellersPostsDTO postsDto = getFollowedUsersPostsById(userId);

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
}
