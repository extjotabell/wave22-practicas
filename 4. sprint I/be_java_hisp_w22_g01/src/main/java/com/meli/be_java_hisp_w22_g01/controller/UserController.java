package com.meli.be_java_hisp_w22_g01.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersList(){
        return null;
    }
}
