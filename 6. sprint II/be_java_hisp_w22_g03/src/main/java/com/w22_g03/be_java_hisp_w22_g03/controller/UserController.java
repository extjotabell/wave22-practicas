package com.w22_g03.be_java_hisp_w22_g03.controller;

import com.w22_g03.be_java_hisp_w22_g03.service.UserService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    //US 0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followASeller(@PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userId,
                                           @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userIdToFollow){
        return new ResponseEntity<>(userService.startFollowing(userId, userIdToFollow), HttpStatus.OK);
    }

    //US 0002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> amountOfFollowersForSeller(@PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userId){
        return new ResponseEntity<>(userService.getNumberOfFollowers(userId), HttpStatus.OK);
    }

    //US 0003
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(@PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userId,
                                          @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowers(userId, order),HttpStatus.OK);
    }

    //US 0004
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowed(@PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userId,
                                         @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowed(userId, order),HttpStatus.OK);}

    //US 0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowASeller(@PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userId,
                                             @PathVariable @NotNull(message = "El  id no puede estar vacío.") @Min(value = 1, message = "El id debe ser mayor a cero") Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.stopFollowing(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
