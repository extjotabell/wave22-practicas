package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.service.IPostService;
import com.meli.be_java_hisp_w22_g01.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IPostService postService;
    private final IUserService userService;

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

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromo(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}