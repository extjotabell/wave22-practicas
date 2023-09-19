package com.example.be_java_hisp_w22_g02.controller;
import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.PromotionDto;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPostService;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class PostController {

    private IPostService postService;
    private IPromotionService promotionService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getLastTwoWeeksPostByUserFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {

        return new ResponseEntity<>(postService.getLastTwoWeeksPostByUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addNewPost(@Valid @RequestBody PostDTO postDto) {
        return ResponseEntity.ok(postService.addNewPost(postDto));
    }

    //---------ENDPOINTS HECHOS INDIVIDUALMENTE----------//

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PromotionDto newPromo){
        promotionService.addNewPromo(newPromo);
        return new ResponseEntity<>("Promotion-Post created succesfully", HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getFollowersCountByUserId(@RequestParam int userId){
        return new ResponseEntity<>(promotionService.getTotalPromotionsByUserId(userId), HttpStatus.OK);
    }

    //----------------------------------------------------//
}

