package com.example.blogProyect.controller;

import com.example.blogProyect.dtos.EntradaBlogDto;
import com.example.blogProyect.repository.IBlogRepository;
import com.example.blogProyect.service.IBlogService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private IBlogService blogService;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody EntradaBlogDto blogDto){
      return ResponseEntity.ok(blogDto);
    }




}
