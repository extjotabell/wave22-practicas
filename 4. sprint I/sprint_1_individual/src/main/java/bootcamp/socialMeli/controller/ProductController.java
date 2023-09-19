package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.service.IPostService;
import bootcamp.socialMeli.service.IProductService;
import jakarta.annotation.Nullable;
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
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    // US 06
    // us 09
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostListDto> getPostsByFollowedUsers(@PathVariable int userId, @Nullable ProductOrderListEnum order) {
        return new ResponseEntity<>(postService.getPostsByFollowedUsers(userId, order), HttpStatus.OK);
    }

    // US 05
    @PostMapping("/post")
    public ResponseEntity<String> addPost(@Valid @RequestBody PostDto postDto) {
        postService.addPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // US 10
    @PostMapping("/promo-post")
    public ResponseEntity<String> addPromoPost(@Valid @RequestBody PromoPostDto promoPostDto) {
        postService.addPost(promoPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // US 11
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDto> getPromoPostsCountByUser(@RequestParam int userId) {
        return new ResponseEntity<>(postService.getPromoPostsCountByUser(userId), HttpStatus.OK);
    }

    // US 12
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoProductsListDto> getPromoPostsListByUser(@RequestParam int userId) {
        return new ResponseEntity<>(postService.getPromoPostsListByUser(userId), HttpStatus.OK);
    }
}
