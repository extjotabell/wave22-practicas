package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void analyzeScoreTest(){
        //Arrange
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matemática", 9.0));
        subjectList.add(new SubjectDTO("Lengua", 7.0));

        StudentDTO request = new StudentDTO("Juan", "", 0.0, subjectList);
        StudentDTO expected = new StudentDTO("Juan", "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.", 8.0, subjectList);

        when(service.analyzeScores(request)).thenReturn(expected);

        //Act
        StudentDTO actual = controller.analyzeScores(request);

        //Assert
        Assertions.assertEquals(expected, actual);


    }

}
