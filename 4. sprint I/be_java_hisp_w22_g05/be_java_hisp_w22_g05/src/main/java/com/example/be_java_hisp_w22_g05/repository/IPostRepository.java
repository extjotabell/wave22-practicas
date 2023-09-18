package com.example.be_java_hisp_w22_g05.repository;


import com.example.be_java_hisp_w22_g05.entity.Post;

import java.util.List;

public interface IPostRepository {
    Post findPostById(int id);
    List<Post> findPostAll();

    Post save(Post post);

    List<Post> findPostByUserId(int userId);
}