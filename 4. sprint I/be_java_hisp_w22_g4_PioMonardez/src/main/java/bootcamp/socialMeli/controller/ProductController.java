package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.service.IPostService;
import bootcamp.socialMeli.service.IProductService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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
    public ResponseEntity<String> addPromoPost(@Valid @RequestBody PromoPostDto promoPostDto)
    {
        return new ResponseEntity<>(postService.addPromoPost(promoPostDto), HttpStatus.OK);
    }

    // US 11
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountByUserDto> getPromoPostByUser(@RequestParam int user_id)
    {
        return new ResponseEntity<>(postService.getPromoPostCountByUser(user_id), HttpStatus.OK);
    }

    // US 12
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListByUserDto> getPromoPostListByUser(int user_id)
    {
        return new ResponseEntity<>(postService.getPromoPostsByUser(user_id), HttpStatus.OK);
    }
}
