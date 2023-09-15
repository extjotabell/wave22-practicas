package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IUserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final Map<Long, User> dbUser = new HashMap<>();

    public UserRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        file = ResourceUtils.getFile("classpath:users.json");
        users = objectMapper.readValue(file, new TypeReference<List<User>>() {
        });

        for (User user: users) {
            dbUser.put(user.getUserId(), user);
        }
    }

    @Override
    public List<Post> getFollowedPostLasTwoWeeks(Long id) {
        User user = dbUser.get(id);
        List<Post> posts = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate lastTwoWeeks = today.minus(2, ChronoUnit.WEEKS);

        for (Post p: user.getPosts()) {
            if ((p.getDate().isAfter(lastTwoWeeks) || p.getDate().isEqual(lastTwoWeeks)) &&
                    (p.getDate().isBefore(today) || p.getDate().isEqual(today))){
                posts.add(p);
            }
        }

        return posts;
    }
}