package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentControllerTest {

    @Mock
    StudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        // Arrange
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));

        // Act
        ResponseEntity<?> responseEntity = studentController.registerStudent(expected);

        // Assert
        assertEquals(ResponseEntity.ok(null), responseEntity);
        verify(studentService, times(1)).create(expected);
    }

    @Test
    void getStudent() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        when(studentService.read(studentId)).thenReturn(expected);

        // Act
        StudentDTO actualStudentDTO = studentController.getStudent(studentId);

        // Assert
        assertEquals(expected, actualStudentDTO);
    }

    @Test
    void modifyStudent() {
        // Arrange
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));

        // Act
        ResponseEntity<?> responseEntity = studentController.modifyStudent(expected);

        // Assert
        assertEquals(ResponseEntity.ok(null), responseEntity);
        verify(studentService, times(1)).update(expected);
    }

    @Test
    void removeStudent() {
        // Arrange
        Long studentId = 1L;

        // Act
        ResponseEntity<?> responseEntity = studentController.removeStudent(studentId);

        // Assert
        assertEquals(ResponseEntity.ok(null), responseEntity);
        verify(studentService, times(1)).delete(studentId);
    }

    @Test
    void listStudents() throws FileNotFoundException {
        // Arrange
        Set<StudentDTO> expectedStudents = new HashSet<>();
        when(studentService.getAll()).thenReturn(expectedStudents);

        // Act
        Set<StudentDTO> actualStudents = studentController.listStudents();

        // Assert
        assertEquals(expectedStudents, actualStudents);
    }
}