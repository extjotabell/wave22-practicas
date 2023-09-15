package com.blog.blog.controller;

import com.blog.blog.dto.MessageDto;
import com.blog.blog.entity.EntradaBlogDto;
import com.blog.blog.service.IServiceBlog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final IServiceBlog service;

    public Controller(IServiceBlog service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> newEntry(@RequestBody EntradaBlogDto entradaBlogDto){
        service.newEntry(entradaBlogDto);
        return new ResponseEntity<>(new MessageDto("Entrada creada con éxito"), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getEntry(@PathVariable int id){
        return new ResponseEntity<>(service.getEntry(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllEntries(){
        return new ResponseEntity<>(service.getAllEntries(), HttpStatus.OK);
    }
}
