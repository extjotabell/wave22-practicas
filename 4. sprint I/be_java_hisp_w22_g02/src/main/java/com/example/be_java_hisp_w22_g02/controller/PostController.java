package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {
    private final IPostService postService;
    public PostController(IPostService postService){
        this.postService = postService;
    }
    @PostMapping("/post")
    public ResponseEntity<PostDTO> addNewPost(@Valid @RequestBody PostDTO postDto){
        return ResponseEntity.ok(postService.addNewPost(postDto));
    }
}
