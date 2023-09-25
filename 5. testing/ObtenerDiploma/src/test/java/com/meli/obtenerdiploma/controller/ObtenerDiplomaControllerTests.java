package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    private ObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    void analyzeScoreTest() {
        StudentDTO studentDTO = TestUtils.getMockStudent("Juan");

        controller.analyzeScores(studentDTO.getId());

        verify(service, atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}
