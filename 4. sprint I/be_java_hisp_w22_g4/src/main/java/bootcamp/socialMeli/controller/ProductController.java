package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.DiscountedPostDto;
import bootcamp.socialMeli.dto.FollowedPostListDto;
import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.service.IPostService;
import bootcamp.socialMeli.service.IProductService;
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
    public ResponseEntity<List<ProductDto>> detProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ProductDto>> getUsers()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPosts()
    {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }
    // US 06
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostListDto> getByFollowedUsers(@PathVariable int userId)
    {
        return new ResponseEntity<>(postService.getPostsByFollowedUsers(userId), HttpStatus.OK);
    }

    @PostMapping("/addPost")
    public ResponseEntity<String> AddPost( @RequestBody DiscountedPostDto postDto)
    {
        return new ResponseEntity<>(postService.addPost(postDto), HttpStatus.OK);
    }

}
