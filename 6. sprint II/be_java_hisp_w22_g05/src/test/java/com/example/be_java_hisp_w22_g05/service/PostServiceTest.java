package com.example.be_java_hisp_w22_g05.service;

import com.example.be_java_hisp_w22_g05.repository.IPostRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    IPostService postService;
}
