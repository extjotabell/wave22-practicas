package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.service.IUserService;
import com.meli.be_java_hisp_w22_g01.service.ISellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final ISellerService sellerService;

    // US 0001
    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> sumAFollower(@PathVariable int userId, @PathVariable int userIdToFollow){
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.setAFollower(userId,userIdToFollow));
    }

    // US 0002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> countFollowers (@PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.countFollowers(userId));
    }

    // US 0003
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersList(@PathVariable int userId,@RequestParam(required = false) String order) {

        if(order == null){
            return new ResponseEntity<>(userService.FollowersList(userId), HttpStatus.OK);
        }else{
            // US 0008-1
            return ResponseEntity.status(HttpStatus.OK).body(userService.orderFollowersDto(userId,order));
        }
    }

    // US 0004
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable int userId,@RequestParam(required = false) String order){
        if(order == null) {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUserFollowedList(userId));
        } else{
            // US 0008-2
            return ResponseEntity.status(HttpStatus.OK).body(userService.orderFollowedDto(userId,order));
        }
    }

    // US 0007
    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return ResponseEntity.status(HttpStatus.OK).body(userService.unfollow(userId, userIdToUnfollow));
    }

}
