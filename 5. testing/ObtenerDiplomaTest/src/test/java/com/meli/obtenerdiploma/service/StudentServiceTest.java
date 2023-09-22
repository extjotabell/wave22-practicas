package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void readTest(){
        //Arrange
        Long param = 1L;
        StudentDTO mockDevol = new StudentDTO();
        StudentDTO devolution = new StudentDTO();
        mockDevol.setId(param);
        devolution.setId(param);

        //Act
        Mockito.when(studentDAO.findById(param)).thenReturn(mockDevol);
        StudentDTO obtain = studentService.read(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);
    }
}
