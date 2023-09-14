package com.w22_g03.be_java_hisp_w22_g03.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w22_g03.be_java_hisp_w22_g03.exception.NotFoundException;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl() throws IOException {
        loadDatabase();
//        User user1 = new User();
//        user1.setUserId(1);
//        user1.setUsername("user1");
//        User user2 = new User();
//        user2.setUserId(2);
//        user2.setUsername("user2");
//        User user3 = new User();
//        user3.setUserId(1);
//        user3.setUsername("user3");
//        this.users.add(user1);
//        this.users.add(user2);
//        this.users.add(user3);
    }

    public User findById(long id) {
        return users.stream().filter(u -> u.getUserId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> findFollowers(int userId) {
        return findById(userId).getFollowers();
    }

    @Override
    public List<User> findFollowed(int userId) {
        return findById(userId).getFollowed();
    }

    private void loadDatabase() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("users.json");
        ObjectMapper mapper = new ObjectMapper();
        this.users = mapper.readValue(classPathResource.getInputStream(), new TypeReference<>() {
        });
    }

    @Override
    public Post savePost(Post post) {
        User userPosting = findById(post.getUser().getUserId());
        if (userPosting == null)
            throw new NotFoundException("The user trying to post does not exist");

        userPosting.getPosts().add(post);
        return post;
    }
}
