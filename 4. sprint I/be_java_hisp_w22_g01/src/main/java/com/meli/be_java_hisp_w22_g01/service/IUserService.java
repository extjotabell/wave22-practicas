package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.response.FollowedDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowersListDTO;

public interface IUserService {

    UserFollowersListDTO FollowersList(int user_id);

    public boolean unfollow(int userId, int userIdToUnfollow);

    FollowedDTO getUserFollowedList(int user_id);
}
