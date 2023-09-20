package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {

    StudentRepository repo= new StudentRepository();

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
