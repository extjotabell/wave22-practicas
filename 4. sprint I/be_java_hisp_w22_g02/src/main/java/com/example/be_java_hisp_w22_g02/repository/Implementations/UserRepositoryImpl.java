package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.entity.UserFollow;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final Map<Integer, User> dbUser = new HashMap<>();

    public UserRepositoryImpl() {
        loadDataBase();
    }

    @Override
    public User findById(Integer id) {
        return dbUser.get(id);
    }


    @Override
    public void followUser(int userId, int userIdToFollow) {
        User user = dbUser.get(userId);
        User userToFollow = dbUser.get(userIdToFollow);
        UserFollow userFollow = new UserFollow(user.getUserId(), user.getUserName());
        UserFollow userFollowToFollow = new UserFollow(userToFollow.getUserId(), userToFollow.getUserName());
        if(!user.getFollowed().contains(userFollowToFollow))
            user.addFollowed(userFollowToFollow);
        if(!userToFollow.getFollowers().contains(userFollow))
            userToFollow.addFollower(userFollow);
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

    @Override
    public User getFollowers(int id) {
        return findById(id);
    }

}