package com.meli.be_java_hisp_w22_g01.controller;

import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.PromoDTO;
import com.meli.be_java_hisp_w22_g01.service.IPostService;
import com.meli.be_java_hisp_w22_g01.service.ISellerService;
import com.meli.be_java_hisp_w22_g01.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IPostService postService;
    private final IUserService userService;
    private final ISellerService sellerService;

    // US_0005
    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    // US_0006
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedList(@PathVariable int userId, @RequestParam(required = false) String order) {

        if (order == null) {
            return new ResponseEntity<>(userService.userFollowedPostList(userId), HttpStatus.OK);
        } else {
            // US_0009
            return new ResponseEntity<>(userService.orderByDateFollowedSellers(userId, order), HttpStatus.OK);
        }
    }

    // US_0010
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromo(@RequestBody PromoDTO promoDTO) {
        postService.createPost(promoDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // US_0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countProductsInPromotion(@RequestParam int userId) {
        return new ResponseEntity<>(sellerService.countProductsInPromotion(userId), HttpStatus.OK);
    }

    // US_0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> listProductsInPromotion(@RequestParam int userId) {
        return new ResponseEntity<>(sellerService.getProductsInPromotion(userId), HttpStatus.OK);
    }


}