package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    void createTest(){
        // ARRANGE
        studentService.create(new StudentDTO());
        // ACT

        // ASSERT
        verify(studentDAO, atLeast(1)).save(any(StudentDTO.class));
    }

    @Test
    void readTest(){
        // ARRANGE
        StudentDTO fakeResponse = new StudentDTO(5L, "Puma", null, null, List.of());
        // ACT
        when(studentDAO.findById(anyLong())).thenReturn(fakeResponse);
        // ASSERT
        Assertions.assertEquals(fakeResponse, studentService.read(9L));
    }

    @Test
    void updateTest(){
        // ARRANGE
        studentService.update(new StudentDTO());
        // ACT

        // ASSERT
        verify(studentDAO, atLeast(1)).save(any(StudentDTO.class));
    }

    @Test
    void deleteTest(){
        // ARRANGE
        studentService.delete(9L);
        // ACT

        // ASSERT
        verify(studentDAO, atLeast(1)).delete(anyLong());
    }

    @Test
    void getAllTest(){
        Set<StudentDTO> fakeStudents = new HashSet<>();

        when(studentRepository.findAll()).thenReturn(fakeStudents);

        Assertions.assertEquals(fakeStudents, studentService.getAll());
    }
}
