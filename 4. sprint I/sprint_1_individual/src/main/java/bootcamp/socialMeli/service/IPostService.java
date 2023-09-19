package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    void addPost(IPostDto iPostDto);
    PromoProductsCountDto getPromoPostsCountByUser(int userId);
    PromoProductsListDto getPromoPostsListByUser(int userId);
}
