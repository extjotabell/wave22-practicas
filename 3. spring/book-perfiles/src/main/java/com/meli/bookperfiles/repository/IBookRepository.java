package com.meli.bookperfiles.repository;



import com.meli.bookperfiles.model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> traerTodos();
    Book findById(Long id);
}
