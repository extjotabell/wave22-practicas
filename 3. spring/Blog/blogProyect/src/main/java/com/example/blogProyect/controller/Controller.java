package com.example.blogProyect.controller;

import com.example.blogProyect.dtos.EntradaBlogDto;
import com.example.blogProyect.repository.IBlogRepository;
import com.example.blogProyect.service.IBlogService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private IBlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<?> getAll(){
        try{
            List<EntradaBlogDto> myList = blogService.findAll();
            return ResponseEntity.ok(myList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/blog")
    public ResponseEntity<?> addItem(@RequestBody EntradaBlogDto blogDto){

        try{
            blogService.add(blogDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Blog creado con éxito");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }




}
