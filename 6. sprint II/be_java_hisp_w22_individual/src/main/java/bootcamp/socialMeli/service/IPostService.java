package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
import bootcamp.socialMeli.dto.PostDto;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    String addPost(PostDto postDto);
}
