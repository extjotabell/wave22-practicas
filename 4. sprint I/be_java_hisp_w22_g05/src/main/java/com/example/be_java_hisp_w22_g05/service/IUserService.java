package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;

public interface IUserService {
    UserFollowedDto follow(int followerId, int userToFollowId);
}
