package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPostRepository;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.HashMap;
import java.io.File;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    private final Map<Long, Post> dbPost = new HashMap<>();

    public PostRepositoryImpl() {
        loadDataBase();
    }

    private void loadDataBase() {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<Post> posts;
        try {
            file = ResourceUtils.getFile("classpath:posts.json");
            posts = objectMapper.readValue(file, new TypeReference<List<Post>>() {
            });
            for (Post post : posts) {
                dbPost.put(post.getPostId(), post);
            }
            System.out.println("Database Post loaded successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




