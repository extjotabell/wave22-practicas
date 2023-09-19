package com.example.be_java_hisp_w22_g02.controller;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PostPromoByUserDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class PostController {

    IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getLastTwoWeeksPostByUserFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {

        return new ResponseEntity<>(postService.getLastTwoWeeksPostByUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addNewPost(@Valid @RequestBody PostDTO postDto) {
        return ResponseEntity.ok(postService.addNewPost(postDto));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostDTO> addPromoPost(@RequestBody PostPromoDTO post) {
        return ResponseEntity.ok(postService.addNewPost(post));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoByUserDTO> getCountPostPromoByUser(@RequestParam int user_id) {
        return ResponseEntity.ok(postService.countPostPromoByUser(user_id));
    }
}

