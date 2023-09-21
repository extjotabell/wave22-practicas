package com.meli.bookperfiles.repository;


import com.meli.bookperfiles.exceptions.BookAlreadyExistException;
import com.meli.bookperfiles.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository{

    List<Book> listaBooks = new ArrayList<>() {{
        add(new Book(1L, "¿Cómo programar en Java?", "Luisina de Paula"));
        add(new Book(2L, "Servidores: ¿Cómo administrarlos?", "Gabriel Guismin"));
    }};
    @Override
    public List<Book> traerTodos() {
        return listaBooks;
    }

    @Override
    public Book findById(Long id) {
        for(Book book: listaBooks){
            if(book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book save (Book book){
        Book bookAux = listaBooks.stream().filter(book1 -> book1.getId() == book.getId()).findFirst().orElse(null);
        if(bookAux != null){
            throw  new BookAlreadyExistException("El libro con ese id ya existe");
        }
        listaBooks.add(book);
        return book;
    }
}
