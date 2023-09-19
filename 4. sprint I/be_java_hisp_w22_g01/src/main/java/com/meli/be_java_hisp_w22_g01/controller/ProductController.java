package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.service.IPostService;
import com.meli.be_java_hisp_w22_g01.service.IUserService;
import com.meli.be_java_hisp_w22_g01.service.PostServiceImp;
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

    // US 0010
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PostDto postDto) {
        return createPost(postDto);
    }

    // US 0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countPromo(@RequestParam int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.countPromo(userId));
    }
    // US 0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> listPromo(@RequestParam int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.listPromo(userId));
    }

}