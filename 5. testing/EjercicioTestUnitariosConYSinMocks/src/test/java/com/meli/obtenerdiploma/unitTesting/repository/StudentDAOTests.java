package com.meli.obtenerdiploma.unitTesting.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentDAOTests {

    @Autowired
    StudentDAO studentDAO;

    @Test
    @DisplayName("Student DAO Save ok Test")
    void saveOkTest(){
        //Arrange
        int expectedSize = studentDAO.getAllStudents().size() + 1;
        StudentDTO student = new StudentDTO(99999L, "Ale", "hola", 10.0, List.of());

        //Act
        studentDAO.save(student);

        //Assert
        Assertions.assertEquals(expectedSize, studentDAO.getAllStudents().size());
    }

    @Test
    @DisplayName("Student DAO Delete ok Test")
    void deleteOkTest(){
        //Arrange
        long id = studentDAO.getAllStudents().size() + 1;
        studentDAO.save(new StudentDTO(id, "Ale", "hola", 10.0, List.of()));

        //Act
        boolean actual = studentDAO.delete(id);

        //Assert
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Student DAO Delete student not found Test")
    void deleteNotOkTest(){
        //Act & Assert
        Assertions.assertFalse(studentDAO.delete(99999L));
    }

    @Test
    @DisplayName("Student DAO Exists ok Test")
    void existsOk(){
        //Arrange
        long id = studentDAO.getAllStudents().size() + 1;
        StudentDTO student = new StudentDTO(id, "Ale", "hola", 10.0, List.of());
        studentDAO.save(student);

        //Act & Assert
        Assertions.assertTrue(studentDAO.exists(student));
        studentDAO.delete(id);
    }

    @Test
    @DisplayName("Student DAO Not exists Test")
    void existsNotOk(){
        //Arrange
        StudentDTO student = new StudentDTO(99999L, "Ale", "hola", 10.0, List.of());

        //Act & Assert
        Assertions.assertFalse(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Student DAO Find by id ok Test")
    void findByIdOkTest(){
        //Arrange
        long id = studentDAO.getAllStudents().size() + 1;
        StudentDTO student = new StudentDTO(id, "Ale", "hola", 10.0, List.of());
        studentDAO.save(student);

        //Act & Assert
        Assertions.assertEquals(student, studentDAO.findById(id));
        studentDAO.delete(id);
    }

    @Test
    @DisplayName("Student DAO Find by id not found Test")
    void findByIdNotFoundTest(){
        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(99999L));
    }
}
