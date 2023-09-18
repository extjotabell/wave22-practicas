package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    void addPost(PostDto postDto);
    void addPromoPost(PromoPostDto promoPostDto);

    PromoProductsCountDto getPromoPostsCountByUser(int userId);
    PromoProductsListDto getPromoPostsListByUser(int userId);
}
