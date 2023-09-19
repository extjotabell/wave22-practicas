package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.request.PromotionPostDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionCountDTO;
import com.example.be_java_hisp_w22_g02.dto.response.PromotionListDTO;
import com.example.be_java_hisp_w22_g02.service.Interfaces.IPromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class PromotionController {

    IPromotionService promoService;

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPromotionPost(@RequestBody PromotionPostDTO promotionPostDTO){
        return new ResponseEntity<>(promoService.addPromotionPost(promotionPostDTO), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromotionsById(@RequestParam int user_id){
        return new ResponseEntity<PromotionCountDTO>(promoService.getPromotionsById(user_id),HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getListPromtionsById(@RequestParam int user_id){
        return new ResponseEntity<PromotionListDTO>(promoService.getListPromotionsById(user_id),HttpStatus.OK);
    }
}
