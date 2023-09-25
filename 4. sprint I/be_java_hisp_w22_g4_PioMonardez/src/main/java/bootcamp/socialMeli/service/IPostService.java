package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    String addPost(IPost post);
    PromoPostCountByUserDto getPromoPostCountByUser(int userId);
    PromoPostListByUserDto getPromoPostsByUser(int userId);
}
