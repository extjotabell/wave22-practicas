package com.example.be_java_hisp_w22_g02.controller;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromoProductCountDTO;
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
    public ResponseEntity<PostDTO> addNewPromoPost(@Valid @RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.addNewPromo(postDTO), HttpStatus.OK);
    }
    @GetMapping("promo-post/count")
    public ResponseEntity<PromoProductCountDTO> getPromosCountByUserId(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getPromoCountByUserId(userId), HttpStatus.OK);
    }
    @GetMapping("promo-post/list")
    public ResponseEntity<List<PostDTO>> getPromosPostsByUserId(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getPromoPostsByUserId(userId), HttpStatus.OK);
    }
}

