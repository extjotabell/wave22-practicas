package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.service.IUserService;
import com.meli.be_java_hisp_w22_g01.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;
    ISellerService sellerService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersList(@PathVariable int userId) {
        return new ResponseEntity<>(userService.FollowersList(userId), HttpStatus.OK);

    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> countFollowers (@PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.countFollowers(userId));
    }

}
