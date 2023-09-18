package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.TotalFollowersDto;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowerDTO;

import com.example.be_java_hisp_w22_g02.dto.response.UserDto;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;


import java.util.List;


public interface IUserService {



    UserFollowedDTO getFollowedUsersById(Integer id);


    void followUser(int userId, int userIdToFollow);

    boolean existsUser(int userId);

    UserDto getUser(int userId);

    List<UserDto> getAllUsers();

    UserFollowerDTO getFollowers(int id);

    TotalFollowersDto getTotalFollowersByUserId(int userId);

    void unfollowUser(Integer userId, Integer userIdToUnfollow);
}
