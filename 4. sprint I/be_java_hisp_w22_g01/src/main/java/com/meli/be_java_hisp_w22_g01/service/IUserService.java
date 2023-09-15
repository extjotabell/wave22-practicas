package com.meli.be_java_hisp_w22_g01.service;

import com.meli.be_java_hisp_w22_g01.dto.response.FollowedDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UnfollowDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowedPostListDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowersListDTO;

import java.util.List;

public interface IUserService {

    UserFollowersListDTO FollowersList(int user_id);

    public UnfollowDTO unfollow(int userId, int userIdToUnfollow);

    FollowedDTO getUserFollowedList(int user_id);

    List<FollowedDTO> orderFollowedsDto(int userId, String order);

    UserFollowedPostListDTO userFollowedPostList(int user_id);
}
