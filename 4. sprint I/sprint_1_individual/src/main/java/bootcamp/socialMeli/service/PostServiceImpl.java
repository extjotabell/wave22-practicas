package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
        if (postList.isEmpty()) throw new NotFoundException("No posts found");

        return postList.stream().map(this::toPostDto).collect(Collectors.toList());
    }

    private PostDto toPostDto(Post post) {
        ProductDto productDto = productService.getProductById(post.getProduct_id());
        ModelMapper modelMapper = new ModelMapper();
        PostDto postDto = modelMapper.map(post, PostDto.class);
        System.out.println("POST DTO CONVERTIDO >>>>> " + postDto);
        postDto.setProduct(productDto);
        return postDto;
    }

    // US 06 & US 09
    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order) {
        // Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowed();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(idUser ->
        {
            List<Post> posts = postRepository.getLatestPostsByUserId(idUser);
            posts.forEach(post -> {
                postDtoList.add(toPostDto(post));
            });
        });

        if (order == ProductOrderListEnum.date_asc)
            return new FollowedPostListDto(
                userId, postDtoList.stream().sorted(Comparator.comparing(PostDto::getDate)).
                collect(Collectors.toList()));

        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.getDate().compareTo(date1.getDate())).
                collect(Collectors.toList()));
    }

    // US 05 & US 10
    @Override
    public void addPost(IPostDto iPostDto) {
        Post post = new Post(iPostDto.getPost_id(),
                iPostDto.getUser_id(),
                iPostDto.getDate(),
                iPostDto.getProduct().getProduct_id(),
                iPostDto.getCategory(),
                iPostDto.getPrice(),
                iPostDto.has_promo(),
                iPostDto.discount());
        int idNewPost = postRepository.addPost(post);

        productService.addProducto(iPostDto.getProduct());
        userService.addPostIdToUser(iPostDto.getUser_id(), idNewPost);;
    }

    // US 11
    @Override
    public PromoProductsCountDto getPromoPostsCountByUser(int userId) {
        List<Post> userPosts = postRepository.getPostsByUserId(userId);

        int numberOfPromoPosts = (int) userPosts.stream().filter(Post::isHas_promo).count();

        return new PromoProductsCountDto(userId, userService.getUserNameById(userId), numberOfPromoPosts);
    }

    // US 12
    @Override
    public PromoProductsListDto getPromoPostsListByUser(int userId) {
        List<Post> userPosts = postRepository.getPostsByUserId(userId);

        List<Post> userPromoPosts = userPosts.stream().filter(Post::isHas_promo).toList();
        List<PromoPostDto> promoPostDtos = new ArrayList<>();

        for (Post userPromoPost : userPromoPosts) {
            ModelMapper modelMapper = new ModelMapper();
            ProductDto userProductPostDto = productService.getProductById(userPromoPost.getProduct_id());
            PromoPostDto promoPostDto = modelMapper.map(userPromoPost, PromoPostDto.class);
            promoPostDto.setProduct(userProductPostDto);
            promoPostDtos.add(promoPostDto);
        }

        return new PromoProductsListDto(userId, userService.getUserNameById(userId), promoPostDtos);
    }

}
