package com.w22_g03.be_java_hisp_w22_g03_bayarri.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.Post;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.model.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl() throws IOException {
        loadDatabase();
    }

    public User findById(long id) {
        return users.stream().filter(u -> u.getUserId() == id).findFirst().orElse(null);
    }

    @Override
    public List<User> findFollowers(int userId) {
        return findById(userId).getFollowers();
    }

    @Override
    public User findFollower(int userIdToFollow, int userId) {
        List<User> listOfFollowers = findFollowers(userIdToFollow);
        Optional<User> user = listOfFollowers.stream().filter(u-> u.getUserId() == userId).findFirst();
        if (user.isPresent()){
            return user.get();
        }
        return null;
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

        userPosting.getPosts().add(post);
        return post;
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }
}
