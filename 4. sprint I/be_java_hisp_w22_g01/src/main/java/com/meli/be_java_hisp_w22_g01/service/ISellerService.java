package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.CountPromotionsDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowMessageDto;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;

import java.util.List;

public interface ISellerService {
    CountFollowersDTO countFollowers(int userId);
    FollowMessageDto setAFollower(int idFollower, int idSeller);

    CountPromotionsDTO countProductsInPromotion(int userId);
}