package com.example.be_java_hisp_w22_g05.repository;

import com.example.be_java_hisp_w22_g05.entity.User;

import java.util.List;


public interface IUserRepository {

    User findUsersById(int id);
    List<User> findAllUsers();

}
