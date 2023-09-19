package com.example.be_java_hisp_w22_g02.repository.Implementations;

import com.example.be_java_hisp_w22_g02.dto.response.FollowedPostDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.entity.User;
import com.example.be_java_hisp_w22_g02.repository.Interfaces.IPostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.*;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    private final Map<Integer, Post> dbPost = new HashMap<>();

    public PostRepositoryImpl() {
        loadDataBase();
    }



    private void loadDataBase(){
        File file;
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        List<Post> posts;
        try {
            file = ResourceUtils.getFile("classpath:posts.json");
            posts = objectMapper.readValue(file, new TypeReference<List<Post>>(){});
            for (Post post : posts) {
                dbPost.put(post.getPostId(), post);
            }
            System.out.println("Database Post loaded successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Post findById(int id){
        return dbPost.get(id);
    }

    public List<Post> findAllPosts(){
        List<Post> posts = new ArrayList<>();
        dbPost.forEach((k,v) -> posts.add(v));
        return posts;
    }


    @Override
    public Post save(Post post) {
        post.setPostId(dbPost.size() + 1);
        dbPost.put(post.getPostId(), post);
        return post;
    }

    @Override
    public List<Post> getPostById(int userId) {
        List<Post> postList = new ArrayList<>();

        for (Map.Entry<Integer,Post> posts: dbPost.entrySet()) {
            if(posts.getValue().getUserId() == userId){
                postList.add(posts.getValue());
            }
        }
        return postList;
    }
}
