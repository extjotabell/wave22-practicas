package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTests {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    void createOkTest(){
        //Act
        service.create(any());

        //Assert
        verify(studentDAO, atLeastOnce()).save(any());
    }

    @Test
    void readOkTest(){
        //Act
        service.read(anyLong());

        //Assert
        verify(studentDAO, atLeastOnce()).findById(anyLong());
    }

    @Test
    void updateOkTest(){
        //Act
        service.update(any());

        //Assert
        verify(studentDAO, atLeastOnce()).save(any());
    }

    @Test
    void deleteOkTest(){
        //Act
        service.delete(anyLong());

        //Assert
        verify(studentDAO, atLeastOnce()).delete(anyLong());
    }

    @Test
    void getAllOkTest(){
        //Act
        service.getAll();

        //Assert
        verify(studentRepository, atLeastOnce()).findAll();
    }

}
