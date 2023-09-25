package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    static StudentDAO studentDAO = new StudentDAO();

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;



    @Test
    void analyzeScoresOkTest() {
        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Pedro");
        expected.setMessage("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.");
        expected.setAverageScore(7.333333333333333);
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO s1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO s2 = new SubjectDTO("Física", 8.0);
        SubjectDTO s3 = new SubjectDTO("Química", 4.0);
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);
        expected.setSubjects(subjects);

        when(studentDAO.findById(expected.getId())).thenReturn(expected);
        StudentDTO actual = obtenerDiplomaService.analyzeScores(expected.getId());

        verify(studentDAO, atLeastOnce()).findById(actual.getId());
        Assertions.assertEquals(expected, actual);

    }


}
