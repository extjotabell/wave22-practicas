package com.example.excepciones.repository;

import com.example.excepciones.model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> traerTodos();
    Book findById(Long id);
}
