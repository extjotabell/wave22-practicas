package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.response.UserFollowDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return ResponseEntity.ok("User followed successfully");
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowDTO> getFollowedUser(@PathVariable Integer userId) {
        UserFollowDTO userFollowDTO = userService.getFollowedUsersById(userId);
        return new ResponseEntity<>(userFollowDTO, HttpStatusCode.valueOf(200));
    }
}
