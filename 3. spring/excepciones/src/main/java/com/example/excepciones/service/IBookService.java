package com.example.excepciones.service;

import com.example.excepciones.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> traerTodos();
    Book findById(Long id);
}
