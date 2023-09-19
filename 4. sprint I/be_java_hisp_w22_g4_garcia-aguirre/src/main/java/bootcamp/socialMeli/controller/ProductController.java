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
    public ResponseEntity<?> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<DiscountedPostDto>> getAllPosts()
    {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    // US 06
    // us 09
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostListDto> getPostsByFollowedUsers(@PathVariable int userId,
                                                                       @RequestParam(required = false, defaultValue = "date_asc") ProductOrderListEnum order)
    {
        return new ResponseEntity<>(postService.getPostsByFollowedUsers(userId, order), HttpStatus.OK);
    }

    // US 05
    @PostMapping("/addPost")
    public ResponseEntity<String> addPost(@RequestBody @Valid PostDto postDto)
    {
        return new ResponseEntity<>(postService.addPost(postDto), HttpStatus.OK);
    }

    // US 10
    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody @Valid DiscountedPostDto postDto)
    {
        return new ResponseEntity<>(postService.addPost(postDto), HttpStatus.OK);
    }

    // US 11
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPostInPromoByUser(@RequestParam Integer user_id){
        return new ResponseEntity<>(this.postService.getPostInPromoByUser(user_id), HttpStatus.OK);
    }

    // US 12
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPostListInPromoByUser(@RequestParam Integer user_id){
        return new ResponseEntity<>(this.postService.getPostListInPromoByUser(user_id), HttpStatus.OK);
    }
}
