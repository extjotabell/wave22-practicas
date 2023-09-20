package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDAOTests {

    @Autowired
    IStudentDAO studentDAO;
    @Autowired
    IStudentRepository repo;

    static StudentDTO studentDTO;
    @BeforeAll
    static void setup(){
        SubjectDTO materia1 = new SubjectDTO("Química", 7.8);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        studentDTO = new StudentDTO(4L, "Carlos", null, null, listaDeMaterias);
    }

    @Test
    void saveOkTest(){

        studentDAO.save(studentDTO);

        Assertions.assertEquals(4, repo.findAll().size());
    }


    @Test
    void deleteOkTest(){

        boolean deleteResponse = studentDAO.delete(4L);

        Assertions.assertTrue(deleteResponse);
    }

    @Test
    void findByIdOkTest(){
        StudentDTO studentDTO1 = studentDAO.findById(2L);

        Assertions.assertNotNull(studentDTO1);
        Assertions.assertEquals(studentDTO1.getId(), 2L);
    }

    @Test
    void findByIdNotFoundTest(){
        Assertions.assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(5L));
    }


}
