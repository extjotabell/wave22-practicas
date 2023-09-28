package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.service.IPostService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
public class PostController {
    private final IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody @Valid PostDto postDto){
        postService.saveNewPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getListPostsFromSellersFollowed(@PathVariable @Min(value = 1, message = "El userId debe ser mayor que 0") int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<List<PostDto>>(postService.getListPostsFromSellersFollowed(userId, order), HttpStatus.OK);
    }
}
