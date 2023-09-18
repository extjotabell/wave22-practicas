package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.DiscountedPostDto;
import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IProductService productService;
    private final IUserService userService;
    ObjectMapper mapper = new ObjectMapper();

    public PostServiceImpl(IPostRepository postRepository, IProductService productService,IUserService userService ) {
        this.postRepository = postRepository;
        this.productService = productService;
        this.userService = userService;
    }
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
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowing();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(u ->
        {
            List<Post> post = postRepository.getLatestPostsByUserId(u);
            post.forEach(x -> {
                ProductDto productDto = productService.getProductById(x.getProduct_id());

                postDtoList.add(new PostDto(
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
        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.getDate().compareTo(date1.getDate())).
                collect(Collectors.toList()));
    }

    @Override
    public String addPost(DiscountedPostDto postDto) {
        if(postDto.getUser_id() == 0 || postDto.getProduct().getProduct_id() == 0 ||  postDto.getDate() == null || postDto.getPrice() == 0){
            throw new BadRequestException("Datos incompletos");
        }
       @Valid Post post = new Post(postDto.getPost_id(),
                postDto.getUser_id(),
                postDto.getDate(),
                postDto.getProduct().getProduct_id(),
                postDto.getCategory(),
                postDto.getPrice(),
                postDto.isHas_promo(),
                postDto.getDiscount());
        int idNewPost = postRepository.addPost(post);
        productService.addProducto(postDto.getProduct());
        return "Se agrego exitosamente un nuevo post con el numero : " + idNewPost;
    }

        //Returning the sorted list ordered by the latest post

}
