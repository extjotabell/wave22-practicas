package com.nicolassalvo.blog.controller;

import com.nicolassalvo.blog.dto.BlogDTO;
import com.nicolassalvo.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        List<BlogDTO> blogs = blogService.getall();
        return ResponseEntity.status(HttpStatus.OK).body(blogs);
    }

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO blog) {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.add(blog));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id) {
        BlogDTO blog = blogService.getById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
