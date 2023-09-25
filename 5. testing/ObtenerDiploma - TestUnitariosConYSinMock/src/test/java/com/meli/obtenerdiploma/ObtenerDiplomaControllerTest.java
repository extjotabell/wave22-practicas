package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresTestOk()
    {
        //ARRANGE
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));
        StudentDTO studentExpected = new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));
        studentExpected.setAverageScore(7.75);
        student.setMessage("El alumno " + student.getStudentName() + " ha obtenido un promedio de 7.75. Puedes mejorar.");
        //ACT
        when(obtenerDiplomaService.analyzeScores(student.getId())).thenReturn(studentExpected);
        StudentDTO expected = obtenerDiplomaController.analyzeScores(student.getId());
        //ASSERT
        assertEquals(expected, studentExpected);
    }
}
