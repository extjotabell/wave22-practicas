package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentControllerTests {

    @Mock
    StudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    void registerStudentOkTest(){
        //Act & Assert
        Assertions.assertEquals(ResponseEntity.ok(null) ,controller.registerStudent(any()));
        verify(service, atLeastOnce()).create(any());
    }

    @Test
    void getStudentOkTest(){
        //Act
        controller.getStudent(anyLong());

        // Assert
        verify(service, atLeastOnce()).read(anyLong());
    }

    @Test
    void modifyTestOkTest(){
        //Act & Assert
        Assertions.assertEquals(ResponseEntity.ok(null), controller.modifyStudent(any()));
        verify(service, atLeastOnce()).update(any());
    }

    @Test
    void removeStudentTestOk(){
        //Act & Assert
        Assertions.assertEquals(ResponseEntity.ok(null), controller.removeStudent(anyLong()));
        verify(service, atLeastOnce()).delete(anyLong());
    }

    @Test
    void listStudentsTestOk(){
        //Act
        controller.listStudents();

        //Assert
        verify(service, atLeastOnce()).getAll();
    }
}
