package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.SellerDto;
import com.meli.be_java_hisp_w22_g01.dto.UserDto;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;

import java.util.List;

public interface ISellerService {
    CountFollowersDTO countFollowers(int userId);
    SellerDto setAFollower(int idFollower, int idSeller);
    List<UserDto> orderFollowersDto(int userId,String order);
}
