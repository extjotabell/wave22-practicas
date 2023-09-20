package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController controller;

    @Test
    void registerStudent() {
        StudentDTO studentDTO = new StudentDTO();
        controller.registerStudent(studentDTO);
        verify(studentService, times(1)).create(studentDTO);
    }

    @Test
    void getStudent() {
        long id = 1;
        controller.getStudent(id);
        verify(studentService, times(1)).read(id);
    }

    @Test
    void modifyStudent() {
        StudentDTO studentDTO = new StudentDTO();
        controller.modifyStudent(studentDTO);
        verify(studentService, times(1)).update(studentDTO);
    }

    @Test
    void removeStudent() {
        long id = 1;
        controller.removeStudent(id);
        verify(studentService, times(1)).delete(id);
    }

    @Test
    void listStudents() {
        controller.listStudents();
        verify(studentService, times(1)).getAll();
    }
}