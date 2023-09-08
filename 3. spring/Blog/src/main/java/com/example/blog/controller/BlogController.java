package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.dto.IdDTO;
import com.example.blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IEntradaBlogService service;

    @PostMapping("/blog")
    public ResponseEntity<IdDTO> addNewEntry(@RequestBody EntradaBlogDto nuevaEntrada){
        // TODO Cambiar para que maneje excepción
        return new ResponseEntity<>(service.save(nuevaEntrada), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getBlogEntryInfo(@PathVariable Integer id){
        // TODO Cambiar para que maneje excepción
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogEntries(){
        // TODO Cambiar para que maneje excepción
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

}
