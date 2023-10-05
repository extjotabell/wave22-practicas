package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTests {

    @Mock
    StudentDAO studentDAO;


    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    void analyzeScoresOkTest() {
        //Arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 10.0));

        StudentDTO expected = new StudentDTO(99999L, "Ale", "", 9.0, subjectDTOList);
        when(studentDAO.findById(any())).thenReturn(expected);

        //Act
        StudentDTO actual = service.analyzeScores(expected.getId());

        //Assert
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(10.0, actual.getAverageScore());
        Assertions.assertFalse(actual.getMessage().isEmpty());
    }

}
