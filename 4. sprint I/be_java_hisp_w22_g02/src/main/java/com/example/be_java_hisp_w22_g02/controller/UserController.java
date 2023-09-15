package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return ResponseEntity.ok("User followed successfully");
    }

    @GetMapping("users/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowers(userId), HttpStatus.OK);
    }
}
