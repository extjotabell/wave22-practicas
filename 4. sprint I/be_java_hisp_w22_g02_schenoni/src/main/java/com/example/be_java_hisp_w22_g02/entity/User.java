package com.example.be_java_hisp_w22_g02.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @JsonAlias({"user_id"})
    private int userId;

    @JsonAlias({"user_name"})
    private String userName;

    private List<UserFollow> followers = new ArrayList<>();
    private List<UserFollow> followed = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<Promotion> promotions = new ArrayList<>();

    public void addFollower(UserFollow follower) {
        followers.add(follower);
    }

    public void addFollowed(UserFollow f) {
        followed.add(f);
    }
}