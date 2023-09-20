package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
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
public class StudentControllerTest {
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
    StudentService service;
    @InjectMocks
    StudentController cont;

    @Test
    void registerStudentOk(){
        cont.registerStudent(studentDTO);
        verify(service, atLeast(1)).create(studentDTO);
    }

    @Test
    void getStudentOk(){
        when(service.read(any())).thenReturn(studentDTO);
        StudentDTO actual = cont.getStudent(any());
        Assertions.assertEquals(studentDTO,actual);
    }

    @Test
    void modifyStudentOk(){
        cont.modifyStudent(studentDTO);
        verify(service,atLeast(1)).update(studentDTO);
    }

    @Test
    void removeStudentOk(){
        cont.removeStudent(any());
        verify(service,atLeast(1)).delete(any());
    }

    @Test
    void listStudentsOk(){
        Set<StudentDTO> resultExpected = new HashSet<>();
        resultExpected.add(studentDTO);
        when(service.getAll()).thenReturn(resultExpected);
        Set<StudentDTO> actual = cont.listStudents();
        Assertions.assertEquals(resultExpected,actual);
    }
}
