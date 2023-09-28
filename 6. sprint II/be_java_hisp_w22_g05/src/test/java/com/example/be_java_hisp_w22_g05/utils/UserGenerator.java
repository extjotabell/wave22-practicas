package com.example.be_java_hisp_w22_g05.utils;

import com.example.be_java_hisp_w22_g05.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {

    private UserGenerator(){

    }

    public static User getUser(){
        List<User> followed = new ArrayList<>();
        User user1 = new User();
        user1.setId(2);
        followed.add(user1);
        User user = new User(1, "Roberto",null, followed);
        return user;
    }
}
