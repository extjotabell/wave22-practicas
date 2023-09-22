package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresCongratulationsTest(){
        //Arrange
        Long param = 1L;
        StudentDTO devolutionExpected = new StudentDTO(param,"Enzo","El alumno Enzo ha obtenido un promedio de 10. Felicitaciones!",10.0, List.of(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Lengua",10.0)
        ));

        StudentDTO devolMock = new StudentDTO(param,"Enzo","",0.0, List.of(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Lengua",10.0)
        ));

        //Act
        Mockito.when(studentDAO.findById(param)).thenReturn(devolMock);
        StudentDTO obtain = obtenerDiplomaService.analyzeScores(param);

        //Assert
        Assertions.assertEquals(devolutionExpected,obtain);
    }

    @Test
    void analyzeScoresImproveTest(){
        //Arrange
        Long param = 1L;
        StudentDTO devolutionExpected = new StudentDTO(param,"Enzo","El alumno Enzo ha obtenido un promedio de 9. Puedes mejorar.",9.0, List.of(
                new SubjectDTO("Matematica", 9.00),
                new SubjectDTO("Lengua",9.00)
        ));

        StudentDTO devolMock = new StudentDTO(param,"Enzo","",0.0, List.of(
                new SubjectDTO("Matematica", 9.00),
                new SubjectDTO("Lengua",9.00)
        ));

        //Act
        Mockito.when(studentDAO.findById(param)).thenReturn(devolMock);
        StudentDTO obtain = obtenerDiplomaService.analyzeScores(param);

        //Assert
        Assertions.assertEquals(devolutionExpected,obtain);

    }


}
