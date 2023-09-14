package com.meli.be_java_hisp_w22_g01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements IPostService{

    @Autowired
    IPostRepository postRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public void createPost(PostDto postDto) {
        Post post = mapper.convertValue(postDto, Post.class);
        postRepository.addPost(post);

    }
}
