package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.UserDto;
import com.example.be_java_hisp_w22_g02.entity.User;

import java.util.List;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;

public interface IUserService {
    UserFollowedDTO getFollowedUsersById(Long id);

    void followUser(int userId, int userIdToFollow);

    boolean existsUser(int userId);

    UserDto getUser(int userId);

    List<UserDto> getAllUsers();
}
