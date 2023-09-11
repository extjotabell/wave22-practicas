package com.ejercicio.blog.controller;

import com.ejercicio.blog.dto.BlogDTO;
import com.ejercicio.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private IBlogService service;

    @GetMapping("/blog")
    public ResponseEntity<?> getAllBlog(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<?> postNewBlog(@RequestBody BlogDTO blogDto){
        return new ResponseEntity<>(service.saveBlog(blogDto), HttpStatus.OK);
    }

}