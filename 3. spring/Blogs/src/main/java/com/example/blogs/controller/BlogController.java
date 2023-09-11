package com.example.blogs.controller;

import com.example.blogs.dto.BlogDTO;
import com.example.blogs.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BlogController {

    IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> createBlog(@RequestBody BlogDTO entrada) {
        return ResponseEntity.ok(blogService.crearEntrada(entrada));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable int id){
        return ResponseEntity.ok(blogService.getBlogDTOByID(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){
        return ResponseEntity.ok(blogService.getAllEntradasBlog());
    }
}
