package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    String addPost(PostDto postDto);
    String addPromoPost(PromoPostDto promoPostDto);
    PromoPostCountByUserDto getPromoPostCountByUser(int userId);
    PromoPostListByUserDto getPromoPostsByUser(int userId);
}
