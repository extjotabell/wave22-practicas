package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService userService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersList(@PathVariable int userId){
        return new ResponseEntity<>(userService.FollowersList(userId), HttpStatus.OK);
    }
}
