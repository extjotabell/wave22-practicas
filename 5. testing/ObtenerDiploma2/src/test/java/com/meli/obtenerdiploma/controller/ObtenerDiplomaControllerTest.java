package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;
    @InjectMocks
    ObtenerDiplomaController controller;

    static StudentDTO studentDTO;
    @BeforeAll
    static void setup(){
        studentDTO = new StudentDTO(4L, "Roman", null, null, List.of());
    }
    @Test
    void analyzeScoresOk(){
        when(service.analyzeScores(any())).thenReturn(studentDTO);
        StudentDTO actual = controller.service.analyzeScores(any());
        Assertions.assertEquals(studentDTO,actual);
    }
}
