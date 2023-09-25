package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.dto.PromoPostCountByUserDto;
import bootcamp.socialMeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getAllPost();
    Post getPostById(int postId);
    List<Post> getPostsByFollowedUsers(int userId);
    List<Post> getPostByUserId(int userId, boolean hasPromo);
    int addPost(Post post);
    List<Post> getPostsByUserId(int userId);
    List<Post> getLatestPostsByUserId(int userId);
    int getPromoPostsCountByUser(int userId);
}
