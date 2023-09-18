package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.*;

public interface PostService {

    PostDTO addPost(PostDTO postDTO);

    UserFollowedSellersPostsDTO  getFollowedUsersPostsById(long userId);

    UserFollowedSellersPostsDTO getFollowedUsersPostsById(long userId, String order);

    PostWithPromoDTO addPostWithPromotion(PostWithPromoDTO postWithPromoDTO);

    SellerPromotionsCountDTO getSellerPromotionsCount(long sellerId);

    SellerPromotionsDTO getSellerPromotions(long sellerId);
}
