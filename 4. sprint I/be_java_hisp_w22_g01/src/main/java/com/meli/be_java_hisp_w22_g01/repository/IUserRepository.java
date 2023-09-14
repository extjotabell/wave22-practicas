package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.User;

import java.util.List;

public interface IUserRepository {
    void save (User user);
    List<User> getAll ();
    User findById(int user_id);
}
