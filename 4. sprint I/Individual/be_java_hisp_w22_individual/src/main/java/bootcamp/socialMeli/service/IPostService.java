package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.*;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    String addPost(PostDto postDto);
    String addPostPromo(DiscountedPostDto discountedPostDto);
    PostPromoCantDto getCantPostPromo(int user_id);
    PostPromoDto getPostPromo(int user_id);
}
