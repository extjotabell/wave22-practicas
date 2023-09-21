package com.meli.bookperfiles.controller;


import com.meli.bookperfiles.model.Book;
import com.meli.bookperfiles.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;


    @GetMapping
    public ResponseEntity<List<Book>> traerTodos() {
        return  ResponseEntity.status(HttpStatus.OK).body(bookService.traerTodos());
    }

    @GetMapping
    public ResponseEntity<?> obtenerSaludo(@RequestParam String name) {
        String message = "hola" + name;
        return  ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Book> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Book> save(@Valid @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }
}
