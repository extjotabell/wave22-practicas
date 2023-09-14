package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;
}
