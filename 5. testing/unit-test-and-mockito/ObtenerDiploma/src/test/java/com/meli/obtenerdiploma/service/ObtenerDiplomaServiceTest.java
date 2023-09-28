package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;
    @Test
    void analyzeScores() {
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(expected);
        StudentDTO actual = obtenerDiplomaService.analyzeScores(expected.getId());
        Assertions.assertEquals(expected, actual);
    }
}