package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.service.IUserService;
import com.meli.be_java_hisp_w22_g01.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    ISellerService sellerService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersList(@PathVariable int userId,@RequestParam(required = false) String order) {

        if(order == null){
            return new ResponseEntity<>(userService.FollowersList(userId), HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(sellerService.orderFollowersDto(userId,order));
        }
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> countFollowers (@PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.countFollowers(userId));
    }

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> sumAFollower(@PathVariable int userId, @PathVariable int sellerId){
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.setAFollower(userId,sellerId));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable int userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserFollowedList(userId));
    }

}
