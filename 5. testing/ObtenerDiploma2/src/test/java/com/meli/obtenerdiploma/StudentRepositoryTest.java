package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentRepositoryTest {


    @Autowired
    IStudentRepository repo;

    /* public StudentRepositoryTest(StudentRepository repo){
        this.repo = repo;
    }*/

    @Test
    void findALl(){
        // ARRANGE
        long largoEsperado = 2; // Ajusta esto según la cantidad esperada de estudiantes en tu archivo JSON

        // ACT
        Set<StudentDTO> lista = repo.findAll();
        long largoReal = lista.size();

        // ASSERTION
        assertEquals(largoEsperado, largoReal);

    }
}
