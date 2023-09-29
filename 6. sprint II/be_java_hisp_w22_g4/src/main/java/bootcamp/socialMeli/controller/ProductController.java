package bootcamp.socialMeli.controller;

import bootcamp.socialMeli.dto.*;
import bootcamp.socialMeli.service.IPostService;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IPostService postService;

    public ProductController( IPostService postService) {
        this.postService = postService;
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
    @PostMapping("/post")
    public ResponseEntity<String> addPost(@Valid @RequestBody PostDto postDto)
    {
        return new ResponseEntity<>(postService.addPost(postDto), HttpStatus.OK);
    }



}