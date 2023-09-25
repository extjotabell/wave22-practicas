package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findAllOk() {
        assertTrue(studentRepository.findAll().size() > 0);
    }
}
