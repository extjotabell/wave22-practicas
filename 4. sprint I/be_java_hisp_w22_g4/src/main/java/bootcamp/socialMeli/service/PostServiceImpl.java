package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.repository.IPostRepository;
import bootcamp.socialMeli.repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;

    public PostServiceImpl(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepository.getAllPost();
        ProductDto productdto =
                postList.stream().map(Post::getProduct).map(
                        product ->
                                new ProductDto(
                                        product.getProduct_id(),
                                        product.getProduct_name(),
                                        product.getType(),
                                        product.getBrand(),
                                        product.getColor(),
                                        product.getNotes()
                                )
                ).toList().stream().findFirst().orElse(null);

        return postList.stream()
                .map(post -> new PostDto(post.getUser_id(), post.getPost_id(), post.getDate(), productdto, post.getCategory(), post.getPrice())).collect(Collectors.toList());
    }

    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId) {
        return null;
    }

}
