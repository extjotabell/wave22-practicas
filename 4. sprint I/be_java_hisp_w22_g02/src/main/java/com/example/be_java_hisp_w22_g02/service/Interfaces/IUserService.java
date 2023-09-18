package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.TotalFollowersDto;

import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserFollowerDTO;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;


import java.util.List;


public interface IUserService {

    UserFollowedDTO getFollowedUsersById(Integer id);

    void followUser(int userId, int userIdToFollow);

    boolean existsUser(int userId);

    UserDTO getUser(int userId);

    List<UserDTO> getAllUsers();

    UserFollowerDTO getFollowers(int id);

    TotalFollowersDto getTotalFollowersByUserId(int userId);

    void unfollowUser(int userId, int userIdToUnfollow);
}
