package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
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

    private StudentDTO studentDTO;

    @BeforeEach
    void setup(){
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Nombre", 10.0));
        subjectDTOList.add(new SubjectDTO("Nombre2", 7.0));
        this.studentDTO = new StudentDTO(1L, "Nombre", "", 8.5, subjectDTOList);
    }

    @Test
    void analyzeScoreOk() {
        // ARRANGE
        String expectedMessage = String.format(
                "El alumno %s ha obtenido un promedio de %s. Puedes mejorar.",
                studentDTO.getStudentName(),
                new DecimalFormat("#.##").format(studentDTO.getAverageScore())
        );

        // ACT
        when(dao.findById(anyLong())).thenReturn(studentDTO);
        // ASSERT
        // AnalyzeScore le pone un mensaje de felicitaciones al student,
        // por lo que el message del student que creamos deja de estar vacio
        assertEquals(expectedMessage, diplomaService.analyzeScores(1L).getMessage());
    }

    @Test
    void analyzeScoreFail(){
        // Arrange
        long id = -4;

        //Act
        //Assert
        assertThrows(NullPointerException.class, () -> diplomaService.analyzeScores(id));
    }

    @Test
    void analyzeScores() {
    }
}