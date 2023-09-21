package com.meli.bookperfiles.repository;

import com.meli.bookperfiles.exceptions.BookAlreadyExistException;
import com.meli.bookperfiles.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    BookRepository bookRepository = new BookRepository();

    @Test
    public void saveBook(){
        //Arrange
        Book book = new Book(3L,"Marina","Carlos Ruiz Zafon");

        //act
        var obtenido = bookRepository.save(book);

        //assert
        Assertions.assertEquals(book,obtenido);

    }

    @Test
    public void saveBookAlreadyExist(){
        //Arrange
        Book book = new Book(2L,"Marina","Carlos Ruiz Zafon");

        //act & assert
        Assertions.assertThrows(BookAlreadyExistException.class,()->{
            bookRepository.save(book);
        });

    }
}
