package com.example.be_java_hisp_w22_g05.service;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;

import java.util.List;

import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;
import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;

public interface IUserService {

    UserFollowedDto follow(int followerId, int userToFollowId);
    UserNumberFollowersDto getNumberFollowers(int userId);
    public UserFollowedDto getListOfUsersFollowedBy(Integer id);
    UserFollowedDto unfollow(int userId, int userIdToUnfollow);

}
