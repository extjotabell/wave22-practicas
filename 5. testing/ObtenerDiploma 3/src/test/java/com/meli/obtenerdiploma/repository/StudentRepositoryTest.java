package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();
    @Test
    public void findAll(){
        //ARRANGE - PREPARAR LOS DATOS A USER - PARAMETROS Y TIPO DE DATO DE LA DEVOLUCIÓN
        Set<StudentDTO> allStudents = new HashSet<>();
        //ACT - CORRER EL MÉTODO DEL REPOSITORY

        var obtenido = studentRepository.findAll();
        // ASSERT - PROBAR ALGUNA COINCIDENCIA PARA VER SI FUNCIONÓ  O NO EL MÉTODO
        Assertions.assertEquals(allStudents.size(), obtenido.size());
    }

}
