package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    StudentDAO studentDAO;
    StudentRepository studentRepository;

    @BeforeEach
    void setup(){
        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }


    @Test
    void saveStudentEmpty() {
        //ARRANGE
        StudentDTO studentToSave = new StudentDTO();

        int numberOfStudentsExpected = studentDAO.getStudentListSize() + 1;

        //ACT
        studentDAO.save(studentToSave);

        //ASSERT
        assertEquals(studentDAO.getStudentListSize(), numberOfStudentsExpected);

    }

    @Test
    void saveStudentNull() {
        // Arrange
        StudentDTO studentNull = null;
        // Act
        // Assert
        assertThrows(NullPointerException.class, () -> studentDAO.save(studentNull));
    }

    @Test
    void deleteOk() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        studentDAO.save(studentDTO);
        long id = studentDTO.getId();

        boolean expectedResult = true;

        //ACT
        boolean result = studentDAO.delete(id);

        //ASSERT
        assertEquals(expectedResult, result);
    }

    @Test
    void deleteNotOk() {
        //ARRANGE
        long id = -1;

        boolean expectedResult = false;

        //ACT
        boolean result = studentDAO.delete(id);

        //ASSERT
        assertEquals(expectedResult, result);
    }

    @Test
    void exists() {
        // ARRANGE
        StudentDTO userToCheckExistance = new StudentDTO(1L, "Alumno", "Mensaje", 10.0, new ArrayList<>());
        // ACT
        boolean userExists = studentDAO.exists(userToCheckExistance);
        // ASSERT
        assertTrue(userExists);
    }
    @Test
    void existsNotFound() {
        // ARRANGE
        StudentDTO userToCheckExistance = new StudentDTO(234234L, "Alumno", "Mensaje", 10.0, new ArrayList<>());
        // ACT
        boolean userExists = studentDAO.exists(userToCheckExistance);
        // ASSERT
        assertFalse(userExists);
    }

    @Test
    void findByIdOk() {
        // ARRANGE
        long expectedUserId = 1;

        // ACT
        StudentDTO studentSaved = studentDAO.findById(1L);

        // ASSERT
        assertEquals(1, studentSaved.getId());
    }

    @Test
    void findByIdNotFound() {
        // Arrange
        long id = -4;
        // Act
        // Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    void updateStudentOk(){

        // Arrange
        StudentDTO studentDTO = studentDAO.findById(1L);
        StudentDTO original = studentDAO.findById(1L);

        studentDTO.setMessage("modificado!");
        String expectedMessage = "modificado!";

        // Act
        studentDAO.save(studentDTO);

        // Assert
        assertEquals(studentDAO.findById(1L).getMessage(), expectedMessage);
    }
}
