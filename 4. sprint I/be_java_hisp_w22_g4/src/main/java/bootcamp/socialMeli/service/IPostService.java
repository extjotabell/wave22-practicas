package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.ProductOrderListEnum;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.PromoCountDto;


import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    String addPost(PostDto postDto);
    String addPromoPost(PostDto promoPost);
    PromoCountDto getPromoPostCount(int userId);
}
