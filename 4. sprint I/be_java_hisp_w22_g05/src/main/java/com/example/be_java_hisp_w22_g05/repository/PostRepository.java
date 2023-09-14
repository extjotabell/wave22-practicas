package com.example.be_java_hisp_w22_g05.repository;

import com.example.be_java_hisp_w22_g05.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository implements IPostRepository{
    private Map<Integer,Post> database = new HashMap<>();
    @Override
    public Post findPostById(int id) {
        return null;
    }

    @Override
    public List<Post> findPostAll() {
        return null;
    }
}
