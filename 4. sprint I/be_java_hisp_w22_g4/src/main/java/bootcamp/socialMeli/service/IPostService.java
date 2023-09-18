package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.DiscountedPostDto;
import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.entity.Post;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId);
    String addPost(DiscountedPostDto postDto);
}
