package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StudentDAOTests {

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IStudentRepository repo;

    @Test
    void saveOkTest(){
        SubjectDTO materia1 = new SubjectDTO("Química", 7.8);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        StudentDTO studentDTO = new StudentDTO(3L, "Carlos", "Hola", 8.2, listaDeMaterias);
        studentDAO.save(studentDTO);

        Assertions.assertEquals(3, repo.findAll().size());
    }

    @Test
    void deleteOkTest(){
        SubjectDTO materia1 = new SubjectDTO("Química", 7.8);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        StudentDTO studentDTO = new StudentDTO(4L, "Pipino el Breve", "Hola", 8.2, listaDeMaterias);
        studentDAO.save(studentDTO);

        boolean deleteResponse = studentDAO.delete(4L);

        Assertions.assertTrue(deleteResponse);
    }

    @Test
    void findByIdOkTest(){
        StudentDTO studentDTO1 = studentDAO.findById(2L);

        Assertions.assertNotNull(studentDTO1);
        Assertions.assertEquals(studentDTO1.getId(), 2L);
    }

}
