package com.example.be_java_hisp_w22_g02.controller;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class PostController {

    IPostService postService;


    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getLastTwoWeeksPostByUserFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {

        return new ResponseEntity<>(postService.getLastTwoWeeksPostByUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addNewPost(@Valid @RequestBody PostDTO postDto) {
        return ResponseEntity.ok(postService.addNewPost(postDto));
    }
}
