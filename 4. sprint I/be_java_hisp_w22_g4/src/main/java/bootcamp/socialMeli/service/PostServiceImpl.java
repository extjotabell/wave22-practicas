package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import bootcamp.socialMeli.repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IProductService productService;

    public PostServiceImpl(IPostRepository postRepository, IProductService productService) {
        this.postRepository = postRepository;
        this.productService = productService;
    }
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepository.getAllPost();
        if (postList.isEmpty()) throw new NotFoundException("No se encontraron posts");
        List<PostDto> postDtoList = new ArrayList<>();

        postList.forEach(post -> {
                    ProductDto product = productService.getProductById(post.getProduct_id());
                    postDtoList.add(new PostDto(post.getUser_id(), post.getPost_id(), post.getDate(), product, post.getCategory(), post.getPrice()));
                });
        return postDtoList;
    }


    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId) {
        return null;
    }

}
