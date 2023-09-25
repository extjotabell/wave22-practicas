package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@SpringBootTest
public class StudentDAOTests {

    @Autowired
    private StudentDAO studentDAO;

    @Test
    void saveStudentOk() {
        StudentDTO studentDTO = new StudentDTO(3L, "Pedro", "asd", 2.0, new ArrayList<>());
        if(studentDAO.exists(studentDTO))
            studentDAO.delete(studentDTO.getId());
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void saveStudentNull() {
        StudentDTO studentDTO = null;
        assertThrows(NullPointerException.class, () -> studentDAO.save(studentDTO));
    }

    @Test
    void deleteStudentOk() {
        StudentDTO studentDTO = new StudentDTO(456L, "Pedro", "asd", 2.0, new ArrayList<>());
        if (!studentDAO.exists(studentDTO))
            studentDAO.save(studentDTO);
        assertTrue(studentDAO.delete(studentDTO.getId()));
    }

    @Test
    void deleteStudentNotOk() {
        assertFalse(studentDAO.delete(99896549L));
    }

    @Test
    void existsStudentOk() {
        StudentDTO studentDTO = new StudentDTO(4L, "Pedro", "asd", 2.0, new ArrayList<>());
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void existsStudentNotOk() {
        StudentDTO studentDTO = new StudentDTO(99999999L, "Pedro", "asd", 2.0, new ArrayList<>());
        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    void findByIdOk() {
        StudentDTO studentDTO = new StudentDTO(98746L, "Pedro", "asd", 2.0, new ArrayList<>());
        if (!studentDAO.exists(studentDTO))
            studentDAO.save(studentDTO);
        assertEquals(studentDTO.getId(), studentDAO.findById(studentDTO.getId()).getId());
    }

    @Test
    void findByIdNotOk() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(9999L));
    }






}
