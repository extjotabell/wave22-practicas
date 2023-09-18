package com.w22_g03.be_java_hisp_w22_g03_bayarri.controller;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.dto.*;
import com.w22_g03.be_java_hisp_w22_g03_bayarri.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedSellersPostsDTO> getFollowedUsersPostsById(@PathVariable long userId,
                                                                                 @RequestParam(required = false) @Pattern(regexp = "^date_(asc|desc)$") String order) {
        if (Objects.nonNull(order)) {
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId, order));
        } else {
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId));
        }
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostDTO> addPromoPost(@RequestBody @Valid PromoPostDTO promoPostDTO) {
        return ResponseEntity.ok(postService.addPost(promoPostDTO));
    }


}
