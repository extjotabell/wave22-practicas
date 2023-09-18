package com.w22_g03.be_java_hisp_w22_g03_bayarri.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private long userId;

    private String username;

    private List<Post> posts;

    private List<User> followed;

    private List<User> followers;

    public boolean isSeller() {
        return !posts.isEmpty();
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public void popFollower(User follower) {
        followers.remove(follower);
    }

    public void addFollowed(User userFollowed) {
        followed.add(userFollowed);
    }

    public void popFollowed(User userFollowed) {
        followed.remove(userFollowed);
    }

}
