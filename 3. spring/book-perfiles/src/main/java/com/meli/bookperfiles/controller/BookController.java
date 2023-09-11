package com.meli.bookperfiles.controller;


import com.meli.bookperfiles.model.Book;
import com.meli.bookperfiles.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;



    @GetMapping
    public List<Book> traerTodos() {
        return  bookService.traerTodos();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }
}
