package com.example.be_java_hisp_w22_g05.repository;

import com.example.be_java_hisp_w22_g05.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> database = new ArrayList<>();

    public UserRepository(){
        User carlos = new User(1,"carlos",new ArrayList<>(),new ArrayList<>());
        User maria = new User(2,"maria",new ArrayList<>(),new ArrayList<>());
        User pedro = new User(3,"pedro",new ArrayList<>(),new ArrayList<>());
        User javier = new User(4,"javier",new ArrayList<>(),new ArrayList<>());
        User lautaro = new User(5, "lautaro", new ArrayList<>(), new ArrayList<>());

        carlos.getFollower().add(maria);
        maria.getFollowed().add(carlos);

        pedro.getFollowed().add(carlos);
        carlos.getFollower().add(pedro);

        javier.getFollower().add(carlos);
        carlos.getFollowed().add(javier);

        javier.getFollower().add(maria);
        maria.getFollowed().add(javier);
        maria.getFollowed().add(pedro);

        javier.getFollowed().add(maria);
        javier.getFollowed().add(carlos);

        database.add(carlos);
        database.add(maria);
        database.add(pedro);
        database.add(javier);
        database.add(lautaro);
    }

    @Override
    public User findUsersById(int id) {
        return database.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseGet(() -> null);
    }

    @Override
    public List<User> findAllUsers() {
        return database;
    }

    @Override
    public User unfollow(User follower, User followed) {
        follower.getFollowed().remove(followed);
        followed.getFollower().remove(follower);
        return follower;
    }

    @Override
    public User follow(User follower, User userToFollow) {
        follower.getFollowed().add(userToFollow);
        userToFollow.getFollower().add(follower);
        return follower;
    }
}
