package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;
import com.example.be_java_hisp_w22_g05.service.IUserService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final IUserService userService;


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable int userId,@PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.followUser(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserNumberFollowersDto> getFollowersCount(@PathVariable
                                                                    @Min(value = 1, message = "El id debe ser mayor a cero")
                                                                    int userId) {
        return ResponseEntity.ok(userService.getNumberFollowers(userId));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getListOfUsersFollowedBy(@PathVariable @NotBlank(message = "El userId debe tener un valor") @Min(value = 0, message = "El userId debe ser mayor que 0") int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getListOfUsersFollowedBy(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable
                                          @Min(value = 1,message = "El id del usuario seguidor debe ser mayor a 0") int userId,
                                      @PathVariable
                                      @Min(value = 1,message = "El id del usuario seguido debe ser mayor a 0") int userIdToUnfollow){
        return new ResponseEntity<>(userService.unfollowUser(userId,userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> findUsersFollowingSeller(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.findUsersFollowingSeller(userId, order),HttpStatus.OK);
    }

}
