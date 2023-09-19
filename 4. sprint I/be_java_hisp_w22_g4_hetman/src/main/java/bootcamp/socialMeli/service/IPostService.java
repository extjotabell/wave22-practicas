package bootcamp.socialMeli.service;

import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.ProductOrderListEnum;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.PromoPostCountDto;

import java.util.List;

public interface IPostService {
    List<PostDto> getAllPosts();
    FollowedPostListDto getPostsByFollowedUsers(int userId, ProductOrderListEnum order);
    String addPost(PostDto postDto);
    PromoPostCountDto countPromoPosts(int userId);
    List<PostDto> getPromoPostsByUser(int userId);

}
