package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository{

    HashMap<Integer, Post> postsDatabase;

    public PostRepositoryImpl() {
        this.postsDatabase = new HashMap<>();
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }
}
