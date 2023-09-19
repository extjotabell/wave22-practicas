package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.entity.Post;
import bootcamp.socialMeli.entity.Product;
import bootcamp.socialMeli.entity.User;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.repository.IPostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectMapper mapper;

    public PostServiceImpl(IPostRepository postRepository, IProductService productService,IUserService userService, ObjectMapper mapper ) {
        this.postRepository = postRepository;
        this.productService = productService;
        this.userService = userService;
        this.mapper = mapper;
    }
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepository.getAllPost();
        if (postList.isEmpty()) throw new NotFoundException("No se encontraron posts en el sistema.");

        return postList.stream().map(post ->
                mapper.convertValue(post, PostDto.class)).collect(Collectors.toList());
    }


    @Override
    public FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order) {
        //Getting each followed user id
        List<Integer> userFollowedId = userService.findUserById(userId).getFollowed();
        List<PostDto> postDtoList = new ArrayList<>();

        userFollowedId.forEach(idUser ->{
            List<Post> posts = postRepository.getLatestPostsByUserId(idUser);
            posts.forEach(post -> {postDtoList.add(mapper.convertValue(post, PostDto.class));
            });
        });

        if(order == ProductOrderListEnum.date_asc) return new FollowedPostListDto(
                userId, postDtoList.stream().sorted(Comparator.comparing(PostDto::getDate)).
                collect(Collectors.toList()));

        return new FollowedPostListDto(
                userId, postDtoList.stream().sorted((date1, date2) -> date2.getDate().compareTo(date1.getDate())).
                collect(Collectors.toList()));
    }

    @Override
    public String addPost(PostDto postDto) {
        User user = userService.findUserById(postDto.getUser_id());
        postDto.setHas_promo(false);
        postDto.setDiscount(0.0);
        Post post = postRepository.addPost(mapper.convertValue(postDto, Post.class));

        productService.addProducto(postDto.getProduct());
        user.getPostList().add(post.getPost_id());

        return "Se agrego exitosamente un nuevo post con el id : " + post.getPost_id();

    }

    @Override
    public String addPromoPost(PostDto postDto) {
        if(postDto.getDiscount() < 0.0){
            throw new BadRequestException("No se puede ingresar un descuento con valor negativo.");
        }else{
            if(!postDto.getHas_promo() && postDto.getDiscount() > 0.0){
                throw new BadRequestException("No se puede ingresar un descuento si la promoción no tiene has_promo en true.");
            }
            if(postDto.getHas_promo() && postDto.getDiscount() == 0.0){
                throw new BadRequestException("No se puede ingresar un descuento si la promoción no tiene un descuento mayor a 0.0.");
            }
        }

        User user = userService.findUserById(postDto.getUser_id());
        Post post = postRepository.addPost(mapper.convertValue(postDto, Post.class));

        productService.addProducto(postDto.getProduct());
        user.getPostList().add(post.getPost_id());

        return "Se agrego exitosamente un nuevo post con el id : " + post.getPost_id();

    }

    @Override
    public PromoCountDto getPromoPostCount(int userId) {
        User user = userService.findUserById(userId);

        return new PromoCountDto(user.getUser_id(), user.getUser_name(), postRepository.getPromoPostCount(userId));
    }
}
