package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.entity.RolEnum;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    ObjectMapper mapper = new ObjectMapper();

    public PostServiceImpl(IPostRepository postRepository, IProductService productService,IUserService userService ) {
        this.postRepository = postRepository;
        this.productService = productService;
        this.userService = userService;
    }
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepository.getAllPost();
        if (postList.isEmpty()) throw new NotFoundException("No se encontraron posts en el sistema.");

        return postList.stream().map(p -> {
            PostDto post= mapper.convertValue(p, PostDto.class);
            post.setProduct(productService.getProductDtoById(p.getProduct_id()));
            return post;
        }).collect(Collectors.toList());
    }

    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order) {
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowed();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(idUser ->
        {
            List<Post> posts = postRepository.getLatestPostsByUserId(idUser);

            posts.stream().map(p -> {
                PostDto post = mapper.convertValue(p, PostDto.class);
                post.setProduct(productService.getProductDtoById(p.getProduct_id()));
                postDtoList.add(post);

                return post;
            }).collect(Collectors.toList());
        });

        if (order == ProductOrderListEnum.date_asc) return new FollowedPostListDto(
                userId, postDtoList.stream().sorted(Comparator.comparing(PostDto::date)).
                collect(Collectors.toList()));

        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.date().compareTo(date1.date())).
                collect(Collectors.toList()));
    }

    @Override
    public String addPost(IPost post) {
        int newPostId;
        User userExist = userService.findUserById(post.user_id());

        // If is the first post, change user RolEnum to VENDEDOR
        if(userExist.getRol() == RolEnum.COMPRADOR) userExist.setRol(RolEnum.VENDEDOR);

        Post newPost = mapper.convertValue(post, Post.class);
        newPost.setProduct_id(post.product().getProduct_id());
        newPostId  = postRepository.addPost(newPost);

        // Check if product already exists
        Product product = productService.getProductById(post.product().getProduct_id());
        if(product == null)
        {
            productService.addProducto(post.product());
        }

        return "Se agrego exitosamente un nuevo post con el id: " + newPostId;
    }

    @Override
    public PromoPostCountByUserDto getPromoPostCountByUser(int userId) {
        User user = userService.findUserById(userId);
        int promoPosts = postRepository.getPromoPostsCountByUser(userId);

        return new PromoPostCountByUserDto(userId, user.getUser_name(), promoPosts);
    }

    @Override
    public PromoPostListByUserDto getPromoPostsByUser(int userId) {
        User user = userService.findUserById(userId);
        List<Post> postList = postRepository.getPostByUserId(userId, true);
        List<PromoPostDto> promoPostDtoList = new ArrayList<>();

        postList.stream().map(p -> {
            PromoPostDto post = mapper.convertValue(p, PromoPostDto.class);
            post.setProduct(productService.getProductDtoById(p.getProduct_id()));
            promoPostDtoList.add(post);
            return post;
        }).collect(Collectors.toList());

        return new PromoPostListByUserDto(userId, user.getUser_name(),
                promoPostDtoList.stream().sorted(Comparator.comparing(PromoPostDto::date)).collect(Collectors.toList())
        );
    }
}
