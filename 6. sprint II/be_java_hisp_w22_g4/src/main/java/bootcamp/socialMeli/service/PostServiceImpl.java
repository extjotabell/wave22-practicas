package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final IPostRepository postRepository;
    private final IProductService productService;
    private final IUserService userService;

    public PostServiceImpl(IPostRepository postRepository, IProductService productService,IUserService userService ) {
        this.postRepository = postRepository;
        this.productService = productService;
        this.userService = userService;
    }
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepository.getAllPost();
        if (postList.isEmpty()) throw new NotFoundException("No se encontraron posts en el sistema.");

        return postList.stream().map(post ->
        {
            ProductDto product = productService.getProductById(post.getProductId());
            return new PostDto(post.getUserId(), post.getPostId(), post.getDate(), product, post.getCategory(), post.getPrice());
        }).collect(Collectors.toList());
    }


    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order) {
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowed();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(idUser ->
        {
            List<Post> post = postRepository.getLatestPostsByUserId(idUser);
            post.forEach(x -> {
                ProductDto productDto = productService.getProductById(x.getProductId());

                postDtoList.add(new PostDto(
                        x.getUserId(),
                        x.getPostId(),
                        x.getDate(),
                        new ProductDto(
                                productDto.getProductId(),
                                productDto.getProductName(),
                                productDto.getType(),
                                productDto.getBrand(),
                                productDto.getColor(),
                                productDto.getNotes()
                        ),
                        x.getCategory(),
                        x.getPrice()));
            });
        });

        if(order == ProductOrderListEnum.dateDesc) return new FollowedPostListDto(
                userId, postDtoList.stream().sorted(Comparator.comparing(PostDto::getDate)).
                collect(Collectors.toList()));

        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.getDate().compareTo(date1.getDate())).
                collect(Collectors.toList()));
    }

    @Override
    public String addPost(PostDto postDto) {
        int idNewPost;
        Post post = new Post(postDto.getPostId(),
                postDto.getPostId(),
                postDto.getDate(),
                postDto.getProduct().getProductId(),
                postDto.getCategory(),
                postDto.getPrice(),false,0);
        idNewPost = postRepository.addPost(post);
        productService.addProducto(postDto.getProduct());

        return "Se agrego exitosamente un nuevo post con el numero : " + idNewPost;
        //Returning the sorted list ordered by the latest post
    }
}
