package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    IUserService userService;

    public PostController(IUserService userService){
        this.userService = userService;
    }
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getLastTwoWeeksPostByUserFollowed(@PathVariable Long userID){

        return new ResponseEntity<>(userService.getLastTwoWeeksPostByUser(userID), HttpStatus.OK);
    }
}
