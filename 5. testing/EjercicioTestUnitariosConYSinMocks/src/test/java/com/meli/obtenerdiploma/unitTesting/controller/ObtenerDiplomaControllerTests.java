package com.meli.obtenerdiploma.unitTesting.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTests {

    @Mock
    ObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void analyzeScoresOkTest(){
        //Act
        controller.analyzeScores(anyLong());

        //Assert
        verify(service, atLeastOnce()).analyzeScores(anyLong());
    }
}
