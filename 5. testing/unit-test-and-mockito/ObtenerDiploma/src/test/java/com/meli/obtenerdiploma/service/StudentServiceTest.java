package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void create() {
        // arrange
        StudentDTO s1 = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        // act
        studentService.create(s1);
        // assert: uso un argument captor para verificar el objeto que le paso al mock de studentDAO y verifico que
        // se invocó el metodo save
        ArgumentCaptor<StudentDTO> argumentCaptor = ArgumentCaptor.forClass(StudentDTO.class);
        Mockito.verify(studentDAO).save(argumentCaptor.capture());
    }

    @Test
    void read() {
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(expected);
        StudentDTO actual = studentService.read(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void update() {
        // arrange
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        // act
        studentService.update(expected);
        // assert
        ArgumentCaptor<StudentDTO> argumentCaptor = ArgumentCaptor.forClass(StudentDTO.class);
        Mockito.verify(studentDAO).save(argumentCaptor.capture());
        StudentDTO capturedStudent = argumentCaptor.getValue();
        assertEquals(expected.getId(), capturedStudent.getId());
        assertEquals(expected.getStudentName(), capturedStudent.getStudentName());
    }

    @Test
    void delete() {
        // arrange
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        studentDAO.getStudents().add(expected);
        // act
        studentService.delete(expected.getId());
        // assert
        ArgumentCaptor<StudentDTO> argumentCaptor = ArgumentCaptor.forClass(StudentDTO.class);
        Mockito.verify(studentDAO).delete(argumentCaptor.capture().getId());
        StudentDTO capturedStudent = argumentCaptor.getValue();
        assertEquals(expected.getId(), capturedStudent.getId());
        assertEquals(expected.getStudentName(), capturedStudent.getStudentName());
    }

    @Test
    void getAll() throws FileNotFoundException {
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0))));
        expected.add(new StudentDTO(2L, "Paula", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0))));
        Mockito.when(studentRepository.findAll()).thenReturn(expected);
        Set<StudentDTO> actual = studentService.getAll();
        assertEquals(expected.size(), actual.size());
    }

}