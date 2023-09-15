package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {

    IPostService postService;


    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getLastTwoWeeksPostByUserFollowed(@PathVariable int userId, @RequestParam (required = false) String order){

        return new ResponseEntity<>(postService.getLastTwoWeeksPostByUser(userId,order), HttpStatus.OK);
    }

}
