package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ObtenerDiplomaServiceTest {

    ObtenerDiplomaService service = new ObtenerDiplomaService();

    @Test
    void analyzeScoreTest(){
        //Arrange
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matemática", 9.0));
        subjectList.add(new SubjectDTO("Lengua", 7.0));

        StudentDTO request = new StudentDTO("Juan", "", 0.0, subjectList);
        StudentDTO expected = new StudentDTO("Juan", "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.", 8.0, subjectList);

        //Act
        StudentDTO actual = service.analyzeScores(request);

        //Assert
        Assertions.assertEquals(expected, actual);
    }


}
