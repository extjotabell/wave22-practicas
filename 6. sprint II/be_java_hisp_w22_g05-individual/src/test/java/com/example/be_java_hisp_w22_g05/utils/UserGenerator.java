package com.example.be_java_hisp_w22_g05.utils;

import com.example.be_java_hisp_w22_g05.dto.*;
import com.example.be_java_hisp_w22_g05.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserGenerator {

    private UserGenerator(){

    }

    public static User getUser(){
        List<User> followed = new ArrayList<>();
        User user1 = new User();
        user1.setId(4);
        followed.add(user1);
        User user = new User(1, "Roberto",null, followed);
        return user;
    }

    public static UserFollowedDto getUserFollowedDtoListDesc(){

        List<UserDto> followed = new ArrayList<>();
        followed.add(new UserDto(2, "maria"));
        followed.add(new UserDto(1, "carlos"));
        UserFollowedDto userFollowedDto = new UserFollowedDto(4, "javier", followed);

        return userFollowedDto;
    }

    public static UserFollowedDto getUserFollowedDtoListAsc(){
        List<UserDto> followed = new ArrayList<>();
        followed.add(new UserDto(1, "carlos"));
        followed.add(new UserDto(2, "maria"));
        UserFollowedDto userFollowedDto = new UserFollowedDto(4, "javier", followed);
        return userFollowedDto;
    }

    public static UserFollowersDto getUserFollowerDtoListDesc(){

        List<UserDto> follower = new ArrayList<>();
        follower.add(new UserDto(2, "maria"));
        follower.add(new UserDto(1, "carlos"));
        UserFollowersDto userFollowersDto = new UserFollowersDto(4, "javier", follower);

        return userFollowersDto;
    }

    public static UserFollowersDto getUserFollowerDtoListAsc(){
        List<UserDto> follower = new ArrayList<>();
        follower.add(new UserDto(1, "carlos"));
        follower.add(new UserDto(2, "maria"));
        UserFollowersDto userFollowersDto = new UserFollowersDto(4, "javier", follower);
        return userFollowersDto;
    }
}
