package com.w22_g03.be_java_hisp_w22_g03_bayarri.controller;

import com.w22_g03.be_java_hisp_w22_g03_bayarri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //US 0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followASeller(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.startFollowing(userId, userIdToFollow), HttpStatus.OK);
    }

    //US 0002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> amountOfFollowersForSeller(@PathVariable int userId){
        return new ResponseEntity<>(userService.getNumberOfFollowers(userId), HttpStatus.OK);
    }

    //US 0003
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowers(userId, order),HttpStatus.OK);
    }

    //US 0004
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowed(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowed(userId, order),HttpStatus.OK);}

    //US 0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowASeller(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(userService.stopFollowing(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
