package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.repository.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;

    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

}
