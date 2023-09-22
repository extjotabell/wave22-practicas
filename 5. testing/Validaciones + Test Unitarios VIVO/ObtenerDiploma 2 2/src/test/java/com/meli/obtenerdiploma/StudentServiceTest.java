package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService underTest;

    @Test
    void createOkTest(){
        StudentDTO paramStudent = new StudentDTO();
        underTest.create(paramStudent);
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(paramStudent);
    }

    @Test
    void readOkTest(){
        StudentDTO expected = new StudentDTO();
        final long studentId = 1L;
        Mockito.when(studentDAO.findById(studentId)).thenReturn(expected);

        StudentDTO current = underTest.read(studentId);
        Assertions.assertEquals(expected, current);
    }

    @Test
    void updateOkTest(){
        StudentDTO paramStudent = new StudentDTO();
        underTest.update(paramStudent);
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(paramStudent);
    }

    @Test
    void deleteOkTest(){
        final long studentId = 1L;
        underTest.delete(studentId);
        Mockito.verify(studentDAO, Mockito.only()).delete(studentId);
    }

    @Test
    void getAllOkTest(){
        Set<StudentDTO> expectedStudenSet = new HashSet<>();

        Mockito.when(studentRepository.findAll()).thenReturn(expectedStudenSet);
        Set<StudentDTO> current = underTest.getAll();

        Assertions.assertEquals(expectedStudenSet, current);
    }
}
