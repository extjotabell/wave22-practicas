package com.example.Blog.controller;

import com.example.Blog.dto.BlogEntryDTO;
import com.example.Blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping
    public ResponseEntity<?> createNewBlogEntry(@RequestBody BlogEntryDTO blogEntryDTO) {

        BlogEntryDTO existingEntry = blogService.getBlogEntry(blogEntryDTO.getId());
        if (existingEntry != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Ya existe una entrada de blog con este Id.");
        }
        int newEntryId = blogService.createNewEntry(blogEntryDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Entrada de blog creada correctamente con Id: " + newEntryId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogEntryById(@PathVariable int id){
        BlogEntryDTO blogEntry = blogService.getBlogEntry(id);
        if (blogEntry == null)
            return new ResponseEntity<>("No existe ningun blog con ese id",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(blogEntry, HttpStatus.OK);
    }
}
