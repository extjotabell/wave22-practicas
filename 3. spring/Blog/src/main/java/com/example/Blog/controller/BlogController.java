package com.example.Blog.controller;

import com.example.Blog.dto.BlogEntryDTO;
import com.example.Blog.exception.AlreadyExistsException;
import com.example.Blog.exception.BlogNotFoundException;
import com.example.Blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            String message = String.format("Ya existe el blog con id: ",existingEntry.getId());
            throw new AlreadyExistsException(message);
        }
        int newEntryId = blogService.createNewEntry(blogEntryDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Entrada de blog creada correctamente con Id: " + newEntryId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBlogEntries(){
        List<BlogEntryDTO> blogEntries = blogService.getAllBlogEntries();
        if(blogEntries.isEmpty()){
            throw new BlogNotFoundException("No hay blogs");
        }
        return new ResponseEntity<>(blogEntries, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogEntryById(@PathVariable int id){
        BlogEntryDTO blogEntry = blogService.getBlogEntry(id);
        if (blogEntry == null)
            throw new BlogNotFoundException("No existe blog con ese id");
        return new ResponseEntity<>(blogEntry, HttpStatus.OK);
    }
}
