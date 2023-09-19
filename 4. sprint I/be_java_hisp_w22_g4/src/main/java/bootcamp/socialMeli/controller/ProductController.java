package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.service.IPostService;
import bootcamp.socialMeli.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;
    private final IPostService postService;

    public ProductController(IProductService productService, IPostService postService) {
        this.productService = productService;
        this.postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts()
    {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    // US 06
    // us 09
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostListDto> getPostsByFollowedUsers(@PathVariable int userId, @RequestParam(required = false) ProductOrderListEnum order)
    {
        return new ResponseEntity<>(postService.getPostsByFollowedUsers(userId, order), HttpStatus.OK);
    }

    // US 05
    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@Valid @RequestBody PostDto postDto)
    {
        return new ResponseEntity<>(postService.addPost(postDto), HttpStatus.OK);
    }

    // US 10
    @PostMapping("/promo-post")
    public ResponseEntity<String> addPromoPost(@RequestBody PostDto promoPost){
        return new ResponseEntity<>(postService.addPromoPost(promoPost), HttpStatus.OK);
    }

    // US 11
    @GetMapping("/promo-post/count?user_id={userId}")
    public ResponseEntity<PromoCountDto> getPromoPostCount(@RequestParam int userId){
        return new ResponseEntity<>(postService.getPromoPostCount(userId), HttpStatus.OK);
    }

}
