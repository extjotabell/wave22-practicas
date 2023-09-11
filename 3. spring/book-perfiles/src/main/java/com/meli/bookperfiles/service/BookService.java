package com.meli.bookperfiles.service;


import com.meli.bookperfiles.exceptions.NotFoundException;
import com.meli.bookperfiles.model.Book;
import com.meli.bookperfiles.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> traerTodos() {
        return bookRepository.traerTodos();
    }

    @Override
    public Book findById(Long id) {
        Book libroEncontrado = bookRepository.findById(id);
        if(libroEncontrado == null){
            throw new NotFoundException("No se encontró el libro con id: " + id);
        }
        return libroEncontrado;
    }
}
