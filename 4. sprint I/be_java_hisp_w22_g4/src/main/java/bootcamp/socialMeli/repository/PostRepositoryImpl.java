package bootcamp.socialMeli.repository;

import bootcamp.socialMeli.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository{
    @Override
    public List<Post> getAllPost() {
        return null;
    }
}
