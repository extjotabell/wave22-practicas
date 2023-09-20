package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentDAO dao;
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void createOk() {
        StudentDTO newStudent = new StudentDTO();
        studentService.create(newStudent);
        verify(dao, times(1)).save(newStudent);
    }

    @Test
    void read() {
        long id = 1;
        studentService.read(id);
        verify(dao, times(1)).findById(id);
    }

    @Test
    void update() {
        StudentDTO newStudent = new StudentDTO();
        studentService.update(newStudent);
        verify(dao, times(1)).save(newStudent);
    }

    @Test
    void delete() {
        long id = 1;
        studentService.delete(id);
        verify(dao, times(1)).delete(id);
    }

    @Test
    void getAll() {
        studentService.getAll();
        verify(studentRepository, times(1)).findAll();
    }
}