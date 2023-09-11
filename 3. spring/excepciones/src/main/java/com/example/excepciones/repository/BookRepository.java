package com.example.excepciones.repository;

import com.example.excepciones.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository{

    List<Book> listaBooks = new ArrayList<>() {{
        add(new Book(1L, "¿Cóm programar en Java", "Luisina de Paula"));
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
}
