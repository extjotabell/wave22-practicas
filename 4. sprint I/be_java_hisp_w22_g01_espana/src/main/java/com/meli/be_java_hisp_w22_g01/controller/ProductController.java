package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.service.IPostService;
import com.meli.be_java_hisp_w22_g01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IPostService postService;
    @Autowired
    IUserService userService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedList(@PathVariable int userId, @RequestParam(required = false) String order) {

        if (order == null) {
            return new ResponseEntity<>(userService.userFollowedPostList(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userService.orderByDateFollowedSellers(userId, order), HttpStatus.OK);
        }
    }

}