package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.entity.User;

public interface IUserRepository {
    User findById(Long id);
}
