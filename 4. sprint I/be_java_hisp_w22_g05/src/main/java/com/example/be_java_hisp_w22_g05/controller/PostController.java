package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.PostPromoCountDto;
import com.example.be_java_hisp_w22_g05.dto.UserPostPromoDto;
import com.example.be_java_hisp_w22_g05.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class PostController {
    private final IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody PostDto postDto){
        postService.saveNewPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostDto>> getListPostsFromSellersFollowed(@PathVariable int userId,@RequestParam(required = false) String order){
        return new ResponseEntity<List<PostDto>>(postService.getListPostsFromSellersFollowed(userId, order), HttpStatus.OK);
    }

    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/promo-post")
    public ResponseEntity<?> newPromotion(@RequestBody PostDto postDto){
        postService.saveNewPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountDto> getQuantityProductsPromoBySeller(@RequestParam int userId){
        return new ResponseEntity<PostPromoCountDto>(postService.findQuantityProductsPromoBySeller(userId), HttpStatus.OK);
    }

    //US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/list")
    public ResponseEntity<UserPostPromoDto> findListProductPromoSeller(@RequestParam int userId){
        return new ResponseEntity<UserPostPromoDto>(postService.findListProductPromoSeller(userId), HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<PostDto>> getAll(){
        return new ResponseEntity<List<PostDto>>(postService.findPostAll(),HttpStatus.OK);
    }
}
