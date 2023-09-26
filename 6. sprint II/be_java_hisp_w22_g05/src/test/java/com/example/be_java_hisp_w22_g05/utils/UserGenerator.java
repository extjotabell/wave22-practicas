package com.example.be_java_hisp_w22_g05.utils;

import com.example.be_java_hisp_w22_g05.entity.User;

import java.util.List;

public class UserGenerator {

    private UserGenerator(){

    }

    public static User getUserWithListFollowed(){
        User followedUser = new User();
        followedUser.setId(2);
        List<User> sellersList = List.of(followedUser);
        User user = new User();
        user.setId(1);
        user.setFollowed(sellersList);
        return user;
    }
}
