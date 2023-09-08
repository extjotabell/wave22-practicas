package com.example.practicaspringblog.controller;

import com.example.practicaspringblog.DTO.EntradaBlogDto;
import com.example.practicaspringblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping
    public ResponseEntity<String> CrearEntradaBlog(@RequestBody EntradaBlogDto nuevaEntrada){
        return blogService.AgregarEntradaBlog(nuevaEntrada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDto> ObtenerEntradaBlog(@PathVariable int id){
        return blogService.ObtenerEntradaBlog(id);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> ObtenerEntradas(){
        return blogService.ObtenerEntradas();
    }
}
