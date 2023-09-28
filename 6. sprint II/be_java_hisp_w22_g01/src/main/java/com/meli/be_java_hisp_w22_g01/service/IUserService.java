package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.response.*;

public interface IUserService {

    UserFollowersListDTO followersList(int userId);

    MessageDTO unfollow(int userId, int userIdToUnfollow);

    FollowedDTO getUserFollowedList(int userId);

    FollowedDTO orderFollowedDto(int userId, String order);

    UserFollowersListDTO orderFollowersDto(int userId, String order);

    UserFollowedPostListDTO userFollowedPostList(int userId);

    UserFollowedPostListDTO orderByDateFollowedSellers(int id, String order);
}
