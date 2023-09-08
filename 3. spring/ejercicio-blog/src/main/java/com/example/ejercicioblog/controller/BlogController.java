package com.example.ejercicioblog.controller;

import com.example.ejercicioblog.dto.BlogEntryDTO;
import com.example.ejercicioblog.exception.BlogEntryIdAlreadyExistsException;
import com.example.ejercicioblog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogEntryService blogEntryService;

    @PostMapping("/blogEntry")
    public ResponseEntity<String> addBlogEntry(@RequestBody BlogEntryDTO blogEntryDTO) throws BlogEntryIdAlreadyExistsException {
        blogEntryService.addNewBlogEntry(blogEntryDTO);
        return ResponseEntity.ok("Blog entry successfully created");
    }

    @GetMapping("/blogEntry")
    public ResponseEntity<List<BlogEntryDTO>> getAllBlogEntries() {
        return ResponseEntity.ok(blogEntryService.getAllBlogEntries());
    }

    @GetMapping("/blogEntry/{id}")
    public ResponseEntity<BlogEntryDTO> getBlogEntryById(@PathVariable int id) {
        return ResponseEntity.ok(blogEntryService.getBlogEntryById(id));
    }
}
