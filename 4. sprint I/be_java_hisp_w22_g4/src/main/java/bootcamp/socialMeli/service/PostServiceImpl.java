package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.dto.UserDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import bootcamp.socialMeli.repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IProductService productService;
    private final IUserService userService;

    public PostServiceImpl(IPostRepository postRepository, IProductService productService, IUserService userService) {
        this.postRepository = postRepository;
        this.productService = productService;
        this.userService = userService;
    }
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepository.getAllPost();
        if (postList.isEmpty()) throw new NotFoundException("No se encontraron posts en el sistema.");

        return postList.stream().map(post ->
        {
            ProductDto product = productService.getProductById(post.getProduct_id());
            return new PostDto(post.getUser_id(), post.getPost_id(), post.getDate(), product, post.getCategory(), post.getPrice());
        }).collect(Collectors.toList());
    }


    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId) {
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowing();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(u ->
        {
            List<Post> post = postRepository.getLatestPostsByUserId(u);
            post.forEach(x -> {
                ProductDto productDto = productService.getProductById(x.getProduct_id());

                postDtoList.add( new PostDto(
                        x.getUser_id(),
                        x.getPost_id(),
                        x.getDate(),
                        new ProductDto(
                                productDto.getProduct_id(),
                                productDto.getProduct_name(),
                                productDto.getType(),
                                productDto.getBrand(),
                                productDto.getColor(),
                                productDto.getNotes()
                                ),
                        x.getCategory(),
                        x.getPrice()));
            });
        });

        //Returning the sorted list ordered by the latest post
        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.getDate().compareTo(date1.getDate())).
                        collect(Collectors.toList()));
    }
}
