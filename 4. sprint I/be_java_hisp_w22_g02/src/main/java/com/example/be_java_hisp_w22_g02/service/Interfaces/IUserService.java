package com.example.be_java_hisp_w22_g02.service.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;

public interface IUserService {
    UserFollowedDTO getFollowedUsersById(Long id);
}
