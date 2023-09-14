package com.w22_g03.be_java_hisp_w22_g03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

    private long userId;

    private String username;

    private List<Post> posts;

    private List<User> followed;

    private List<User> followers;

    public boolean isVendor(){
        if (!posts.isEmpty()){
            return true;
        }
        return false;
    }

    public void addFollower(User follower){
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
