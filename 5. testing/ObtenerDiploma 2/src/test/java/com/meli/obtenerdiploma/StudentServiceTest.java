package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    static StudentDTO studentDTO;
    @BeforeAll
    static void setup(){
        SubjectDTO materia1 = new SubjectDTO("Química", 7.8);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        studentDTO = new StudentDTO(4L, "Carlos", null, null, listaDeMaterias);
    }

    @Mock
    StudentDAO dao;

    @Mock
    StudentRepository repo;

    @InjectMocks
    StudentService service;

    @Test
    void createOk(){
        service.create(studentDTO);
        verify(dao, atLeast(1)).save(studentDTO);
    }

    @Test
    void readOk(){
        when(dao.findById(any())).thenReturn(studentDTO);
        StudentDTO actual = service.read(any());
        Assertions.assertEquals(studentDTO,actual);
    }

    @Test
    void updateOk(){
        service.create(studentDTO);
        verify(dao, atLeast(1)).save(studentDTO);
    }

    @Test
    void deleteOk(){
       service.delete(any());
       verify(dao,atLeast(1)).delete(any());
    }

    @Test
    void getAllOk(){
        Set<StudentDTO> returnExpected = new HashSet<>();
        returnExpected.add(studentDTO);
        when(repo.findAll()).thenReturn(returnExpected);
        Set<StudentDTO> actual = service.getAll();
        Assertions.assertEquals(returnExpected,actual);
    }
}
