package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController underTest;

    @Test
    void analyzeScoresOkTest(){
        StudentDTO expected = new StudentDTO();
        long studentId = 1;

        Mockito.when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expected);

        StudentDTO current = underTest.analyzeScores(studentId);

        Assertions.assertEquals(expected, current);
    }
}
