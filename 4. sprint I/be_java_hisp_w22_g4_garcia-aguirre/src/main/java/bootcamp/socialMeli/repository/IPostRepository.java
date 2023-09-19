package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getAllPost();
    Post getPostById(int postId);
    List<Post> getPostsByFollowedUsers(int userId);
    Integer addPost(Post post);
    List<Post> getPostsByUserId(int userId);
    List<Post> getLatestPostsByUserId(int userId);

    Integer getPromoCountByUserId(Integer userId);

    List<Post> getPromoPostsByUser(Integer userId);
}
