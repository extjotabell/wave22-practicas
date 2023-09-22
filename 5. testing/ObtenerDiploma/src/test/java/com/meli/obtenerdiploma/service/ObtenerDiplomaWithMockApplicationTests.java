package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaWithMockApplicationTests {
    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    @Test
    public void analyzeScores_InputEqualsOutput() {
        StudentDTO inputStudent = new StudentDTO();
        inputStudent.setId(17L);
        inputStudent.setStudentName("John Doe");
        inputStudent.setSubjects(Collections.singletonList(new SubjectDTO("Math", 80.0)));
        double averageExpected = 80.0;

        Mockito.when(studentDAO.findById(17L)).thenReturn(inputStudent);

        StudentDTO result = obtenerDiplomaService.analyzeScores(17L);

        assertNotNull(result);
        assertEquals(averageExpected, result.getAverageScore());
    }

    @Test
    public void analyzeScores_CalculateAverage() {
        StudentDTO inputStudent = new StudentDTO();
        inputStudent.setId(17L);
        inputStudent.setStudentName("Mati Marin");
        inputStudent.setSubjects(Arrays.asList(new SubjectDTO("Math", 8.0), new SubjectDTO("Science", 4.0)));

        Mockito.when(studentDAO.findById(17L)).thenReturn(inputStudent);

        StudentDTO result = obtenerDiplomaService.analyzeScores(17L);

        assertEquals(6.0, result.getAverageScore());
        assertEquals("El alumno Mati Marin ha obtenido un promedio de 6. Puedes mejorar.", result.getMessage());
    }

    @Test
    public void analyzeScores_CalculateAveragewith10Average() {
        StudentDTO inputStudent = new StudentDTO();
        inputStudent.setId(17L);
        inputStudent.setStudentName("Mati Marin");
        inputStudent.setSubjects(Arrays.asList(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));

        Mockito.when(studentDAO.findById(17L)).thenReturn(inputStudent);

        StudentDTO result = obtenerDiplomaService.analyzeScores(17L);

        assertEquals(10.0, result.getAverageScore());
        assertEquals("El alumno Mati Marin ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
    }

}
