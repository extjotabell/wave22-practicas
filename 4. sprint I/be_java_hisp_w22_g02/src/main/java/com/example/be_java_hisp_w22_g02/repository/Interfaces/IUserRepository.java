package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;



import com.example.be_java_hisp_w22_g02.entity.User;

import java.util.List;

@Repository
public interface IUserRepository {
    User findById(Integer id);

    void followUser(int userId, int userIdToFollow);

    List<User> getAllUsers();

    public Map<Integer,Post> getFollowedPostLasTwoWeeks(Long id);

}
