package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final Map<Integer, User> dbUser = new HashMap<>();

    public UserRepositoryImpl() {
        loadDataBase();
    }

    @Override
    public void followUser(int userId, int userIdToFollow) {
        User user = dbUser.get(userId);
        User userToFollow = dbUser.get(userId);
        user.addFollower(userToFollow);
    }

    @Override
    public User getUser(int userId) {
        return dbUser.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> newList = new ArrayList<>();
        dbUser.forEach((k,v) -> newList.add(v));
        return newList;
    }

    private void loadDataBase(){
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            users = objectMapper.readValue(file, new TypeReference<List<User>>(){});
            for (User user : users) {
                dbUser.put(user.getUserId(), user);
            }
            System.out.println("Database User loaded successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}