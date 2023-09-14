package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;

public interface ISellerService {
    CountFollowersDTO countFollowers(int userId);
}
