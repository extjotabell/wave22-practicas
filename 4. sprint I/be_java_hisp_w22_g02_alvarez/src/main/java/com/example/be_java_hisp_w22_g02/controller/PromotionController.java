package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.request.PostPromoDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.UserDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class PromotionController {
    private final IPromotionService iPromotionService;

    @PostMapping("/promo-post")
    ResponseEntity<?> postPromoPost(@RequestBody PostPromoDTO postPromoDTO) {
        iPromotionService.addPromoPost(postPromoDTO);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/promo-post/count")
    ResponseEntity<PromoPostCountDTO> getCountOfPromoPost(@RequestParam Integer userId) {
        PromoPostCountDTO promo = iPromotionService.getPromoPostsById(userId);
        return new ResponseEntity<>(promo, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/promo-post/list")
    ResponseEntity<UserDTO> getUserPromoPosts(@RequestParam Integer userId) {
        UserDTO user = iPromotionService.getAllPostsById(userId);
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }
}