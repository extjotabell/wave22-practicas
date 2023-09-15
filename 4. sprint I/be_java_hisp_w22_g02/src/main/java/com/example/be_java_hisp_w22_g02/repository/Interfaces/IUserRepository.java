package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.entity.User;

import java.util.List;


public interface IUserRepository {
    User findById(Long id);

    void followUser(int userId, int userIdToFollow);

    User getUser(int userId);

    List<User> getAllUsers();

}
