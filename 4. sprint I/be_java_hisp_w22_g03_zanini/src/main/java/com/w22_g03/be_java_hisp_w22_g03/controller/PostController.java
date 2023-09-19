package com.w22_g03.be_java_hisp_w22_g03.controller;

import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.PromoPostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.UserFollowedSellersPostsDTO;
import com.w22_g03.be_java_hisp_w22_g03.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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

    @PostMapping("/promo-post")
    public ResponseEntity<PromoPostDTO> addPost(@RequestBody @Valid PromoPostDTO promoPostDTO) {
        return ResponseEntity.ok(postService.addPromoPost(promoPostDTO));
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

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountOfPromoProductByVendor(@RequestParam(name = "user_id") Long userId){
        return ResponseEntity.ok(postService.countOfPromoProductByVendor(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getListOfPromoProductByVendor(@RequestParam(name = "user_id") Long userId){
        return ResponseEntity.ok(postService.listOfPromoProductByVendor(userId));
    }

    //Endpoint sin finalizar para buscar productos en promocion donde se aplica cualquier filtro
    //@GetMapping("/promo-post/listByFilter")
    //public ResponseEntity<?> test(@RequestParam Map<String, String> params){
    //    return ResponseEntity.ok(postService.promoProductsByFilter(params));
    //}

}
