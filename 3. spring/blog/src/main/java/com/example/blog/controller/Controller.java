package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.service.EntradaBlogService;
import com.example.blog.service.IEntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    IEntradaBlogService entradaBlog;
    public Controller(EntradaBlogService entradaBlog) {
        this.entradaBlog = entradaBlog;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> crearEntrada(@RequestBody EntradaBlogDTO entradaBlogDTO){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlog(int id){
        return new ResponseEntity<>(entradaBlog.getEntradaBlogById(id), HttpStatus.OK);
    }
}
