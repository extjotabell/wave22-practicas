package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @ParameterizedTest
    @CsvSource(value = {"3, Renzo, Math, 10, Physics, 9, El alumno Renzo ha obtenido un promedio de 9.5. Felicitaciones!, 9.5",
            "4, Hernan, Math, 7, Physics, 9, El alumno Hernan ha obtenido un promedio de 8. Puedes mejorar., 8.0"})
    void analyzeScores(long id, String name, String subjectName1, double score1, String subjectName2, double score2, String expectedMessage, Double expectedAverage) {

        StudentDTO fakeResponse = new StudentDTO(id, name, null, null, List.of(new SubjectDTO(subjectName1, score1), new SubjectDTO(subjectName2, score2)));
        Mockito.when(studentDAO.findById(anyLong())).thenReturn(fakeResponse);
        StudentDTO result = obtenerDiplomaService.analyzeScores(58L);
        Assertions.assertEquals(expectedMessage, result.getMessage());
        Assertions.assertEquals(expectedAverage, result.getAverageScore());

    }
}