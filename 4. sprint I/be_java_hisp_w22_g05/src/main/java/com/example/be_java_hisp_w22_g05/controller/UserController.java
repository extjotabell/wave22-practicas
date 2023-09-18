package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;
import com.example.be_java_hisp_w22_g05.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userId,@PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.follow(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserNumberFollowersDto> getFollowersCount(@PathVariable int userId) {
        return ResponseEntity.ok(userService.getNumberFollowers(userId));
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getListOfUsersFollowedBy(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getListOfUsersFollowedBy(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(userService.unfollow(userId,userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> findUsersFollowingSeller(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.findUsersFollowingSeller(userId, order),HttpStatus.OK);
    }

}
