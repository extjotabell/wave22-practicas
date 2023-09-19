package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.response.*;

public interface ISellerService {
    CountFollowersDTO countFollowers(int userId);
    FollowMessageDto setAFollower(int idFollower, int idSeller);

    CountPromotionsDTO countProductsInPromotion(int userId);

    ListPromotionPostDTO getProductsInPromotion(int userId);
}
