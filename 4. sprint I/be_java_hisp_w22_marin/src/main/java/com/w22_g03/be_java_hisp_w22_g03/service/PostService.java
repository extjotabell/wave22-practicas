package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.GetPostPromoDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.PromoPostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.UserFollowedSellersPostsDTO;

public interface PostService {

    PostDTO addPost(PostDTO postDTO);

    UserFollowedSellersPostsDTO  getFollowedUsersPostsById(long userId);

    UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order);

    GetPostPromoDTO getPostWithPromo(long userId);
    
    PromoPostDTO addPostWithPromo(PromoPostDTO updatePostDTO);
}
