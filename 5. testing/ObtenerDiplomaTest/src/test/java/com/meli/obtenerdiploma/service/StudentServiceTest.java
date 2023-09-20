package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void createTest() {
        studentService.create(new StudentDTO());
        Mockito.verify(studentDAO, Mockito.atLeast(1)).save(any(StudentDTO.class));
    }

    @Test
    void readTest() {
        StudentDTO fakeResponse = new StudentDTO(5L, "Renzo", null, null, List.of());
        Mockito.when(studentDAO.findById(anyLong())).thenReturn(fakeResponse);
        Assertions.assertEquals(fakeResponse, studentService.read(9L));
    }

    @Test
    void updateTest() {
        studentService.update(new StudentDTO());
        Mockito.verify(studentDAO, Mockito.atLeast(1)).save(any(StudentDTO.class));
    }

    @Test
    void deleteTest() {
        studentService.delete(9L);
        Mockito.verify(studentDAO, Mockito.atLeast(1)).delete(anyLong());
    }

    @Test
    void getAll() {

        Set<StudentDTO> fakeStudents = new HashSet<>();
        Mockito.when(studentRepository.findAll()).thenReturn(fakeStudents);
        Assertions.assertEquals(fakeStudents, studentService.getAll());

    }

}