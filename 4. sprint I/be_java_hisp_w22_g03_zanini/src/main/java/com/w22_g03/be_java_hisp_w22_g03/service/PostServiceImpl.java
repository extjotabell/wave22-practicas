package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.*;
import com.w22_g03.be_java_hisp_w22_g03.exception.BadRequestException;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.apache.commons.text.CaseUtils;

import java.util.*;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private UserService userService;

    @Override
    public PostDTO addPost(PostDTO postDTO) {

        User user = userService.findById(postDTO.getUserId());

        Post post = mapPostDtoToPost(postDTO, user);
        post.setPostId(this.postRepository.countPosts() + 1);

        this.postRepository.savePost(post);
        postDTO.setPostId(post.getPostId());
        return postDTO;
    }

    @Override
    public PromoPostDTO addPromoPost(PromoPostDTO promoPostDTO) {
        User user = userService.findById(promoPostDTO.getUserId());
        Post post = mapPromoPostDtoToPost(promoPostDTO, user);
        post.setPostId(this.postRepository.countPosts() + 1);
        this.postRepository.savePost(post);
        promoPostDTO.setPostId(post.getPostId());
        return promoPostDTO;
    }

    @Override
    public NumberOfPromoProductsDTO countOfPromoProductByVendor(Long userId) {
        User user = userService.findById(userId);
        int countOfPromoProducts = countPromoProducts(user.getPosts());
        return NumberOfPromoProductsDTO.buildNumberOfPromoProductsDTO(user, countOfPromoProducts);
    }

    @Override
    public PostByVendorDTO listOfPromoProductByVendor(Long userId){
        User user = userService.findById(userId);
        List<Post> promoPost = promoProductsByVendor(user.getPosts());
        List<PromoPostDTO> promoPostDTOs = new ArrayList<>();
        for (Post post : promoPost) {
            promoPostDTOs.add(mapPostToPromoPostDto(post));
        }
        return PostByVendorDTO.buildPostByVendorDTO(user,promoPostDTOs);
    }
    
    @Override
    public PostByVendorDTO promoProductsByFilter(Map<String, String> params){
        Map<String, String> camelCaseParams = convertSnakeCaseToCamelCaseParams(params);
        if (camelCaseParams.get("userId") == null) throw new BadRequestException("Must provide user_id");   //Necesario para solo buscar productos de un vendedor
        User user = userService.findById(Long.parseLong(camelCaseParams.get("userId")));
        camelCaseParams.remove("userId");   //Remove para que solo queden parametros de productos
        List<Post> promoPost = promoProductsByVendor(user.getPosts());  //Productos solo en promocion
        for (Post post : promoPost) {   //Logica para comparar parametros de filtros con los productos en promocion
            for (Map.Entry<String, String> param: camelCaseParams.entrySet()) {

            }
        }
        return null;
    }

    private Map<String, String> convertSnakeCaseToCamelCaseParams(Map<String, String> params){
        Map<String, String> camelCaseParams = new HashMap<>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            camelCaseParams.put(CaseUtils.toCamelCase(param.getKey(),false, new char[]{'_'}),param.getValue());
        }
        return camelCaseParams;
    }

    private int countPromoProducts(List<Post> posts){
        int count = 0;
        for (Post post : posts) if (post.isHasPromo()) count+=1;
        return count;
    }

    private List<Post> promoProductsByVendor(List<Post> posts){
        List<Post> promoPosts = new ArrayList<>();
        for (Post post : posts) if (post.isHasPromo()) promoPosts.add(post);
        return promoPosts;
    }

    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId) {
        return this.getFollowedUsersPostsById(userId, "date_desc");
    }

    public UserFollowedSellersPostsDTO getAllFollowedUsersPostsById(long userId) {
        User user = userService.findById(userId);
        List<Post> twoWeekOldPostsBySeller = postRepository.findTwoWeekOldPostsFromFollowedByUser(user);

        return mapPostsToUserFollowedSellersPostsDto(twoWeekOldPostsBySeller, userId);
    }

    private UserFollowedSellersPostsDTO mapPostsToUserFollowedSellersPostsDto(List<Post> twoWeekOldPostsBySeller, long userId) {
        UserFollowedSellersPostsDTO userFollowedSellersPostsDTO = new UserFollowedSellersPostsDTO();

        userFollowedSellersPostsDTO.setUserId(userId);
        userFollowedSellersPostsDTO.setPosts(
                twoWeekOldPostsBySeller.stream()
                .map(this::mapPostToPostDto)
                .toList());

        return userFollowedSellersPostsDTO;
    }

    private Post mapPostDtoToPost(PostDTO postDTO, User user) {
        ModelMapper mapper = new ModelMapper();
        Post post = mapper.map(postDTO, Post.class);
        post.setProduct(mapper.map(postDTO.getProduct(), Product.class));
        post.setUser(user);
        return post;
    }

    private Post mapPromoPostDtoToPost(PromoPostDTO promoPostDTO, User user) {
        ModelMapper mapper = new ModelMapper();
        Post post = mapper.map(promoPostDTO, Post.class);
        post.setProduct(mapper.map(promoPostDTO.getProduct(), Product.class));
        post.setUser(user);
        return post;
    }

    private  PostDTO mapPostToPostDto(Post post) {
        ModelMapper mapper = new ModelMapper();
        PostDTO postDto = mapper.map(post, PostDTO.class);
        postDto.setProduct(mapper.map(post.getProduct(), ProductDTO.class));
        postDto.setUserId(post.getUser().getUserId());
        return postDto;
    }

    private PromoPostDTO mapPostToPromoPostDto(Post post) {
        ModelMapper mapper = new ModelMapper();
        PromoPostDTO promoPostDTO = mapper.map(post, PromoPostDTO.class);
        promoPostDTO.setProduct(mapper.map(post.getProduct(), ProductDTO.class));
        promoPostDTO.setUserId(post.getUser().getUserId());
        return promoPostDTO;
    }

    @Override
    public UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order) {
        UserFollowedSellersPostsDTO postsDto = getAllFollowedUsersPostsById(userId);

        postsDto.setPosts(sortByDate(order, postsDto.getPosts()));

        return postsDto;
    }

    private List<PostDTO> sortByDate(String order, List<PostDTO> postsDto) {
        if(order.equals("date_asc")){
            return postsDto.stream().sorted(Comparator.comparing(PostDTO::getDate)).toList();
        }else{
            return postsDto.stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList();
        }
    }
}
