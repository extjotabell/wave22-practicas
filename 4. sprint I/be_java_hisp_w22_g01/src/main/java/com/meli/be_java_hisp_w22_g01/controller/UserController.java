package com.meli.be_java_hisp_w22_g01.controller;

<<<<<<< HEAD
import com.meli.be_java_hisp_w22_g01.service.IUserService;
=======
import com.meli.be_java_hisp_w22_g01.service.ISellerService;
>>>>>>> f48249c2a373159d479c008021014845ccd6b52d
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
<<<<<<< HEAD
    IUserService userService;

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersList(@PathVariable int userId){
        return new ResponseEntity<>(userService.FollowersList(userId), HttpStatus.OK);
=======
    ISellerService sellerService;

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> countFollowers (@PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.countFollowers(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followersList(@PathVariable int userId){
        return null;
>>>>>>> f48249c2a373159d479c008021014845ccd6b52d
    }
}
