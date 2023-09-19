package com.example.be_java_hisp_w22_g02.controller;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserPromoCountDTO;
import com.example.be_java_hisp_w22_g02.entity.Post;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getLastTwoWeeksPostByUserFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(postService.getLastTwoWeeksPostByUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addNewPost(@Valid @RequestBody PostDTO postDto) {
        return ResponseEntity.ok(postService.addNewPost(postDto));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostDTO> addPromoPost(@RequestBody PostDTO promoDTO){
        return ResponseEntity.ok(postService.addPromoPost(promoDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<UserPromoCountDTO> getTotalPromoCount(@RequestParam int user_id){
        return ResponseEntity.ok(postService.getTotalPromoCount(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PostDTO>> getAllPromotionPosts(@RequestParam int user_id){
        return ResponseEntity.ok(postService.getAllPromotionPosts(user_id));
    }
}

