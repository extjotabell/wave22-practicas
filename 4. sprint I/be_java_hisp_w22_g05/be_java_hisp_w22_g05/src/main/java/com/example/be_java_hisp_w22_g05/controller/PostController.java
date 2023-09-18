package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.*;
import com.example.be_java_hisp_w22_g05.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> newPost(@RequestBody PostDto postDto){
        postService.saveNewPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostDto>> getListPostsFromSellersFollowed(@PathVariable int userId,@RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getListPostsFromSellersFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoDto> newPromoPost(@RequestBody PostPromoDto postPromoDto){
        postService.saveNewPostPromo(postPromoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountDto> getPromotionsCount(@RequestParam int userId) {
        return ResponseEntity.ok(postService.getNumberPromotions(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromotionsDto> getPromotions(@RequestParam int userId) {
        return ResponseEntity.ok(postService.getPromotions(userId));
    }
}
