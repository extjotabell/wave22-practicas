package com.w22_g03.be_java_hisp_w22_g03.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.w22_g03.be_java_hisp_w22_g03.dto.*;
import com.w22_g03.be_java_hisp_w22_g03.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@Validated
public class PostController {

    private PostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addPost(@RequestBody @Valid PostDTO postDTO) {
        return ResponseEntity.ok(postService.addPost(postDTO));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostWithPromoDTO> addPostWithPromotion(@RequestBody @Valid PostWithPromoDTO postWithPromoDTO){
        return ResponseEntity.ok(this.postService.addPostWithPromotion(postWithPromoDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedSellersPostsDTO> getFollowedUsersPostsById(@PathVariable long userId,
                                                                                 @RequestParam(required = false) @Pattern(regexp = "^date_(asc|desc)$") String order) {
        if(Objects.nonNull(order)){
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId, order));
        }else {
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId));
        }
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromotionsCountDTO> getSellerPromotionsCount(@RequestParam(name = "user_id") long sellerId){
        return ResponseEntity.ok(this.postService.getSellerPromotionsCount(sellerId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromotionsDTO> getSellerPromotions(@RequestParam(name = "user_id") long sellerId){
        return ResponseEntity.ok(this.postService.getSellerPromotions(sellerId));
    }

}
