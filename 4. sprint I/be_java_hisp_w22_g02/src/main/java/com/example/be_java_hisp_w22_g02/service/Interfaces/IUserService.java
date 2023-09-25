package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.*;


public interface IUserService {

    UserFollowedDTO getFollowed(Integer id, String order);

    SuccessDTO followUser(int userId, int userIdToFollow);

    UserFollowerDTO getFollowers(int id, String order);

    TotalFollowersDto getTotalFollowersByUserId(int userId);

    SuccessDTO unfollowUser(int userId, int userIdToUnfollow);
    PostDTO addUserPost(PostDTO post);
    TwoWeeksPostDTO getLastTwoWeeksPostByUser(int userId, String order);
}
