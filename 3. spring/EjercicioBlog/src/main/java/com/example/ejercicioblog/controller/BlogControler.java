package com.example.ejercicioblog.controller;

import com.example.ejercicioblog.dto.BlogDto;
import com.example.ejercicioblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogControler {

    @Autowired
    private IBlogService service;

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlog(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable Integer id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<?> postNewBlog(@RequestBody BlogDto blogDto){
        return new ResponseEntity<>(service.saveBlog(blogDto), HttpStatus.OK);
    }

}
