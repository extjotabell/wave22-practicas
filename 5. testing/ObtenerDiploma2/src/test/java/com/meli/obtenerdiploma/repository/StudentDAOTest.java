package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    StudentDAO dao;
    StudentRepository studentRepository;

    @BeforeEach
    void setup(){
        this.dao = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }


    @Test
    void saveStudentEmpty() {
        //ARRANGE
        StudentDTO studentToSave = new StudentDTO();

        int numberOfStudentsExpected = dao.getStudentListSize() + 1;

        //ACT
        dao.save(studentToSave);

        //ASSERT
        assertEquals(dao.getStudentListSize(), numberOfStudentsExpected);
        
    }

    @Test
    void saveStudentNull() {
        // Arrange
        StudentDTO studentNull = null;
        // Act
        // Assert
        assertThrows(NullPointerException.class, () -> dao.save(studentNull));
    }

    @Test
    void deleteOk() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        dao.save(studentDTO);
        long id = studentDTO.getId();

        boolean expectedResult = true;

        //ACT
        boolean result = dao.delete(id);

        //ASSERT
        assertEquals(expectedResult, result);
    }

    @Test
    void deleteNotOk() {
        //ARRANGE
        long id = -1;

        boolean expectedResult = false;

        //ACT
        boolean result = dao.delete(id);

        //ASSERT
        assertEquals(expectedResult, result);
    }

    @Test
    void exists() {
        // ARRANGE
        StudentDTO userToCheckExistance = new StudentDTO(1L, "Alumno", "Mensaje", 10.0, new ArrayList<>());
        // ACT
        boolean userExists = dao.exists(userToCheckExistance);
        // ASSERT
        assertTrue(userExists);
    }
    @Test
    void existsNotFound() {
        // ARRANGE
        StudentDTO userToCheckExistance = new StudentDTO(234234L, "Alumno", "Mensaje", 10.0, new ArrayList<>());
        // ACT
        boolean userExists = dao.exists(userToCheckExistance);
        // ASSERT
        assertFalse(userExists);
    }

    @Test
    void findByIdOk() {
        // ARRANGE
        long expectedUserId = 1;

        // ACT
        StudentDTO studentSaved = dao.findById(1L);

        // ASSERT
        assertEquals(1, studentSaved.getId());
    }

    @Test
    void findByIdNotFound() {
        // Arrange
        long id = -4;
        // Act
        // Assert
        assertThrows(StudentNotFoundException.class, () -> dao.findById(id));
    }

    @Test
    void updateStudentOk(){

        // Arrange
        StudentDTO studentDTO = dao.findById(1L);
        StudentDTO original = dao.findById(1L);

        studentDTO.setMessage("modificado!");
        String expectedMessage = "modificado!";

        // Act
        dao.save(studentDTO);

        // Assert
        assertEquals(dao.findById(1L).getMessage(), expectedMessage);
    }
}