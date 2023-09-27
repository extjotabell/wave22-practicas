package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAll ();
    User findById(int userId);
    void updateUser(int userId, User user);
    List<Seller> getAllFollows(User user);
}
