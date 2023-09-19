package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.response.*;

public interface IUserService {

    UserFollowersListDTO FollowersList(int user_id);

    public UnfollowDTO unfollow(int userId, int userIdToUnfollow);

    FollowedDTO getUserFollowedList(int user_id);

    FollowedDTO orderFollowsDto(int userId, String order);

    UserFollowersListDTO orderFollowersDto(int userId, String order);

    UserFollowedPostListDTO userFollowedPostList(int user_id);

    UserFollowedPostListDTO orderByDateFollowedSellers(int id, String order);


}
