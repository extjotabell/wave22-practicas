package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowedDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return ResponseEntity.ok("User followed successfully");
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowedUser(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        UserFollowedDTO userFollowedDTO = userService.getFollowedUsersById(userId, order);
        return new ResponseEntity<>(userFollowedDTO, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCountByUserId(@PathVariable int userId){
        return new ResponseEntity<>(userService.getTotalFollowersByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>("User unfollowed succesfully.", HttpStatus.valueOf(200));
    }

}
