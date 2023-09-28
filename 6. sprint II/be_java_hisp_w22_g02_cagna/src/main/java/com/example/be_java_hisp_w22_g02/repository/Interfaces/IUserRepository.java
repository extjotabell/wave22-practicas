package com.example.be_java_hisp_w22_g02.repository.Interfaces;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import java.util.List;
import com.example.be_java_hisp_w22_g02.entity.User;



public interface IUserRepository {
    User findById(Integer id);
    void followUser(int userId, int userIdToFollow);
    List<Post> getFollowedPostLasTwoWeeks(int id);
    List<Post> getFollowedPostLasTwoWeeksOrd(int userId, String order);
    boolean existingUserById(Integer id);
    void unFollowUser(Integer userId, Integer userIdToUnfollow);
    void addPostToUser(Post post, Integer id);
}
