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

        return postList.stream().map(this::getPostDto).collect(Collectors.toList());
    }

    private PostDto getPostDto(Post post)
    {
        ProductDto product = productService.getProductDtoById(post.getProduct_id());
        return new PostDto(post.getUser_id(), post.getPost_id(), post.getDate(), product, post.getCategory(), post.getPrice());
    }

    private PromoPostDto getPromoPostDto(Post post)
    {
        ProductDto product = productService.getProductDtoById(post.getProduct_id());
        return new PromoPostDto(post.getUser_id(), post.getPost_id(), post.getDate(), product, post.getCategory(), post.getPrice(), post.isHas_promo(), post.getDiscount());
    }

    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order) {
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowed();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(idUser ->
        {
            List<Post> posts = postRepository.getLatestPostsByUserId(idUser);
            posts.forEach(post -> {
                postDtoList.add(this.getPostDto(post));
            });
        });

        if (order == ProductOrderListEnum.date_asc) return new FollowedPostListDto(
                userId, postDtoList.stream().sorted(Comparator.comparing(PostDto::get_date)).
                collect(Collectors.toList()));

        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.get_date().compareTo(date1.get_date())).
                collect(Collectors.toList()));
    }

    @Override
    public String addPost(IPost post) {
        int newPostId;
        User userExist = userService.findUserById(post.get_user_id());

        // If is the first post, change user RolEnum to VENDEDOR
        if(userExist.getRol() == RolEnum.COMPRADOR) userExist.setRol(RolEnum.VENDEDOR);

        Post newPost = new Post(post.get_post_id(),
                post.get_user_id(),
                post.get_date(),
                post.get_product().getProduct_id(),
                post.get_category(),
                post.get_price(),
                post.get_has_promo(),
                post.get_discount());
        newPostId = postRepository.addPost(newPost);

        Product product = productService.getProductById(post.get_product().getProduct_id());

        // Check if product exists
        if(product == null)
        {
            productService.addProducto(post.get_product());
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

        postList.forEach(p ->
        {
            promoPostDtoList.add(this.getPromoPostDto(p));
        });
        return new PromoPostListByUserDto(userId, user.getUser_name(),
                promoPostDtoList.stream().sorted(Comparator.comparing(PromoPostDto::get_date)).collect(Collectors.toList())
        );
    }
}
