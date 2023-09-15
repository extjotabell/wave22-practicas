package com.w22_g03.be_java_hisp_w22_g03.service;

import com.w22_g03.be_java_hisp_w22_g03.dto.*;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    ResponseDTO startFollowing(int userId, int userIdToFollow);

    ResponseDTO stopFollowing(int userId, int userIdToUnfollow);

    FollowerDTO getFollowers(int userId, String order);

    FollowedDTO getFollowed(int userId, String order);

    NumberOfFollowersDTO getNumberOfFollowers(int userId);

    User findById(long userId);

}