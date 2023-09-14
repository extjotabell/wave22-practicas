package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.repository.IPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService{
    private final IPostRepository postRepository;
}
