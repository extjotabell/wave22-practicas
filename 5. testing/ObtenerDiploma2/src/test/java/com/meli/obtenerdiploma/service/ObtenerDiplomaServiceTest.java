package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO dao;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    void analyzeScoreOk() {
        // ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Nombre", 10.0));
        subjectDTOList.add(new SubjectDTO("Nombre2", 7.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Nombre", "", 8.5, subjectDTOList);

        // ACT
        when(dao.findById(anyLong())).thenReturn(studentDTO);

        // ASSERT
        // AnalyzeScore le pone un mensaje de felicitaciones al student,
        // por lo que el message del student que creamos deja de estar vacio :)
        assertNotEquals("", diplomaService.analyzeScores(1L).getMessage());
    }

    @Test
    void analyzeScoreAverage9() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Nombre", 10.0));
        subjectDTOList.add(new SubjectDTO("Nombre2", 10.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Nombre", "", 8.5, subjectDTOList);
        String expectedMessage = "Felicitaciones!";

        when(dao.findById(anyLong())).thenReturn(studentDTO);

        String resultMessage = diplomaService.analyzeScores(1L).getMessage();

        assertTrue(resultMessage.contains(expectedMessage));
    }

    void analyzeScoreAverageLessThan9() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Nombre", 10.0));
        subjectDTOList.add(new SubjectDTO("Nombre2", 10.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Nombre", "", 8.5, subjectDTOList);
        String expectedMessage = "Puedes mejorar!";

        when(dao.findById(anyLong())).thenReturn(studentDTO);

        String resultMessage = diplomaService.analyzeScores(1L).getMessage();

        assertTrue(resultMessage.contains(expectedMessage));
    }
}