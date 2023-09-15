package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.repository.IPostRepository;
import com.example.be_java_hisp_w22_g05.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody PostDto postDto){
        postService.save(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
