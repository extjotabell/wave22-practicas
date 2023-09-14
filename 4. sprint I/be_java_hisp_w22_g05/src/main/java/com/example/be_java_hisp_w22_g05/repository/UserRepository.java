package com.example.be_java_hisp_w22_g05.repository;

import com.example.be_java_hisp_w22_g05.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {
    private Map<Integer,User> database = new HashMap<>();
    @Override
    public User findUsersById(int id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
