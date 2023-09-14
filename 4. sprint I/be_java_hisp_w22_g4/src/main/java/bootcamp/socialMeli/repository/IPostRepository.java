package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getAllPost();
}
