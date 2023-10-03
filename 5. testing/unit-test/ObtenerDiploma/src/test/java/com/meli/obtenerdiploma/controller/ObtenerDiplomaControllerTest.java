package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ObtenerDiplomaControllerTest {
    @Mock
    ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores() {
        StudentDTO expected = new StudentDTO(1l, "Iara", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(expected);
        StudentDTO actual = obtenerDiplomaController.analyzeScores(1L);
        assertEquals(expected, actual);
    }
}