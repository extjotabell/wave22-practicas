package com.w22_g03.be_java_hisp_w22_g03.repository;

import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.User;

import java.util.List;

public interface UserRepository {

    User findById(long id);

    List<User> findFollowers(int userId);

    User findFollower(int userIdToFollow, int userId);

    List<User> findFollowed(int userId);

    Post savePost(Post post);

    List<User> findAll();


}
