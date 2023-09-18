package com.w22_g03.be_java_hisp_w22_g03_bayarri.service;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.*;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.User;

public interface UserService {
    ResponseDTO startFollowing(int userId, int userIdToFollow);

    ResponseDTO stopFollowing(int userId, int userIdToUnfollow);

    FollowerDTO getFollowers(int userId, String order);

    FollowedDTO getFollowed(int userId, String order);

    NumberOfFollowersDTO getNumberOfFollowers(int userId);

    User findById(long userId);

}