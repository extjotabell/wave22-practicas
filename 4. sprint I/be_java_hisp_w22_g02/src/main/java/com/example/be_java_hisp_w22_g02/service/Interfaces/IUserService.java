package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.*;

import com.example.be_java_hisp_w22_g02.entity.Post;


import java.util.List;


public interface IUserService {

    UserFollowedDTO getFollowedUsersById(Integer id, String order);

    void followUser(int userId, int userIdToFollow);

    boolean existsUser(int userId);

    UserDTO getUser(int userId);

    List<UserDTO> getAllUsers();

    UserFollowerDTO getFollowers(int id, String order);

    TotalFollowersDto getTotalFollowersByUserId(int userId);

    void unfollowUser(int userId, int userIdToUnfollow);
    void addUserPost(Post post, Integer userId);
}
