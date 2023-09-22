package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaWhitMockApplicationTests {

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;


    @Test
    void findById() {
        StudentDTO student = new StudentDTO();
        student.setId(7L);
        student.setStudentName("Mati Marin");
        student.setSubjects(List.of(new SubjectDTO("Math", 9.0)));
        student.setAverageScore(9.0);
        double averageExpected = 9.0;

        Mockito.when(obtenerDiplomaController.analyzeScores(7L)).thenReturn(student);

        StudentDTO foundStudent = obtenerDiplomaService.analyzeScores(7L);

        assertNotNull(foundStudent);
        assertEquals(averageExpected, foundStudent.getAverageScore());
    }

    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        Mockito.when(obtenerDiplomaController.analyzeScores(Mockito.any())).thenThrow(new StudentNotFoundException(999L));
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(999L));
    }

}
