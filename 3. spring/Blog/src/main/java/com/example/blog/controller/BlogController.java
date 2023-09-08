package com.example.blog.controller;

import com.example.blog.dto.CrearEntradaBlogDTO;
import com.example.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("blog")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<?> addBlog(@RequestBody CrearEntradaBlogDTO entradaBlog){
        return new ResponseEntity<>(this.blogService.addBlog(entradaBlog), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable Integer id){
        return new ResponseEntity<>(this.blogService.getBlog(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBlogs(){
        return new ResponseEntity<>(this.blogService.getAll(), HttpStatus.OK);
    }
}
