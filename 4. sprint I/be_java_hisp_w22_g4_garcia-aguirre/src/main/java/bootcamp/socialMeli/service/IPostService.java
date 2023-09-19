package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;

import java.util.List;

public interface IPostService {
    List<DiscountedPostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    String addPost(PostDto postDto);

    PromoCountDto getPostInPromoByUser(Integer userId);

    PromoPostsByUserDto getPostListInPromoByUser(Integer userId);
}
