package com.example.be_java_hisp_w22_g05.service;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;

import com.example.be_java_hisp_w22_g05.dto.UserFollowersDto;
import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;

public interface IUserService {

    UserFollowedDto followUser(int followerId, int userToFollowId);
    UserNumberFollowersDto getNumberFollowers(int userId);
    UserFollowedDto unfollowUser(int userId, int userIdToUnfollow);
    UserFollowersDto findUsersFollowingSeller(int userId, String order);
    UserFollowedDto getListOfUsersFollowedBy(Integer id, String order);


}

