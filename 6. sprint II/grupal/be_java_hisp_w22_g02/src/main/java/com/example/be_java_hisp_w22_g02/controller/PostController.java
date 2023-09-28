package com.example.be_java_hisp_w22_g02.controller;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class PostController {

    private IUserService userService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getLastTwoWeeksPostByUserFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {

        return new ResponseEntity<>(userService.getLastTwoWeeksPostByUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addNewPost(@Valid @RequestBody PostDTO postDto) {
        return new ResponseEntity<>(userService.addUserPost(postDto), HttpStatus.OK);
    }
}

