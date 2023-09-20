package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    StudentRepository studentRepository;
    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    private Set<StudentDTO> studentList;
    private StudentDTO studentDTO;

    @BeforeEach
    void setup(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Nombre", 10.0));
        subjectDTOList.add(new SubjectDTO("Nombre2", 7.0));

        studentDTO = new StudentDTO(1L, "Nombre1", "", 8.5, subjectDTOList);
        studentList = new HashSet<>();
        studentList.add(studentDTO);
    }

    @Test
    void create() {
        // Arrange
        // Act
        studentService.create(studentDTO);
        // Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    void read() {
        //Arrange
        StudentDTO expected = studentDTO;
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        //Act
        StudentDTO actual = studentService.read(1L);
        //Assert
        assertSame(actual, studentDTO);
    }

    @Test
    void update() {
        // Arrange
        studentDTO.setStudentName("Cambionombre");
        // Act
        studentService.update(studentDTO);
        // Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }

    @Test
    void delete() {
        //Arrange
        //Act
        studentService.delete(studentDTO.getId());
        //Assert
        verify(studentDAO, atLeast(1)).delete(studentDTO.getId());
    }

    @Test
    void getAll() {
        //Arrange
        Set<StudentDTO> expectedList = studentList;

        //Act
        when(studentRepository.findAll()).thenReturn(studentList);
        Set<StudentDTO> actualList = studentService.getAll();

        //Verify
        assertSame(actualList, expectedList);

    }
}