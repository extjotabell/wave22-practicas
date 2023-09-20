package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
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
public class ObtenerDiplomaController {
    static StudentDTO studentDTO;
    @BeforeAll
    static void setup(){
        SubjectDTO materia1 = new SubjectDTO("Química", 7.8);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        studentDTO = new StudentDTO(4L, "Carlos", null, null, listaDeMaterias);
    }

    @Mock
    ObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController cont;

    @Test
    void analyzeScoresOk(){
        when(service.analyzeScores(any())).thenReturn(studentDTO);
        StudentDTO actual = cont.service.analyzeScores(any());
        Assertions.assertEquals(studentDTO,actual);
    }
}
