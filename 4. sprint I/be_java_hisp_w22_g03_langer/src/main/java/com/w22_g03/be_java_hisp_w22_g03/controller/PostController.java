package com.w22_g03.be_java_hisp_w22_g03.controller;

import com.w22_g03.be_java_hisp_w22_g03.dto.*;
import com.w22_g03.be_java_hisp_w22_g03.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@Validated
public class PostController {

    private PostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addPost(@RequestBody @Valid PostDTO postDTO) {
        return ResponseEntity.ok(postService.addPost(postDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedSellersPostsDTO> getFollowedUsersPostsById(@PathVariable long userId,
                                                                                 @RequestParam(required = false) @Pattern(regexp = "^date_(asc|desc)$") String order) {
        if(Objects.nonNull(order)){
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId, order));
        }else {
            return ResponseEntity.ok(this.postService.getFollowedUsersPostsById(userId));
        }
    }

    // US 0010
    @PostMapping("/promo-post")
    public ResponseEntity<PostDTO> addPromoPost(@RequestBody @Valid PostDTO postDTO){
        return new ResponseEntity<>(postService.addPromoPost(postDTO), HttpStatus.OK);
    }

    // US 0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<NumberOfPromosDTO> getNumberOfPromos(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getPromoCount(userId), HttpStatus.OK);
    }

    // US 0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<PostsBySellerDTO> getAllPostsFromSeller(@RequestParam("user_id") int userId,
                                                                  @RequestParam(required = false) @Pattern(regexp = "^(3[01]|[12][0-9]|0?[1-9])(\\/|-)(1[0-2]|0?[1-9])\\2([0-9]{2})?[0-9]{2}$") String since,
                                                                  @RequestParam(required = false) @Pattern(regexp = "^(3[01]|[12][0-9]|0?[1-9])(\\/|-)(1[0-2]|0?[1-9])\\2([0-9]{2})?[0-9]{2}$") String upTo){
        return new ResponseEntity<>(postService.getPromoList(userId, since, upTo), HttpStatus.OK);
    }

}
