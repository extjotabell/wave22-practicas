package com.meli.bookperfiles.service;



import com.meli.bookperfiles.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> traerTodos();
    Book findById(Long id);
    Book save (Book book);
}
