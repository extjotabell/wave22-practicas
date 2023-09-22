package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository repository;

    @Test
    void findAllOkTest(){
        Assertions.assertEquals(repository.findAll().size(),2);
    }
}
