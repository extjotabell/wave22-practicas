package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getAllPosts();

    Post getPostById(int postId);

    void addPost(Post post);

    void updatePost(int postId, Post updatedPost);

    void deletePost(int postId);
}
