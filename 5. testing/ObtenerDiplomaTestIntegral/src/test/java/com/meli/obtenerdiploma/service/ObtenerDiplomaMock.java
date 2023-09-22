package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaMock {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService service;


    @Test
    public void analyzeScoresTest(){
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO(1L,"Juan", "",0.0,
                        List.of(new SubjectDTO("Matemática",9.0),
                                new SubjectDTO("Física",7.0),
                                new SubjectDTO("Química",6.0)));

        Mockito.when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        studentDTO.setAverageScore(7.333333333333333);
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 7.33");
        



    }

    @Test
    public void calculateAverageTest(@NotEmpty(message = "La lista de materias no puede estar vacía.") List<@Valid SubjectDTO> subjects){
        List<SubjectDTO> subjectDTO = new ArrayList<>();
        subjectDTO.add(new SubjectDTO("Matemática",9.0));
        subjectDTO.add(new SubjectDTO("Física",7.0));
        subjectDTO.add(new SubjectDTO("Química",6.0));

        double promedio = subjectDTO.stream()
                      .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / subjectDTO.size();
        ;
        Assertions.assertEquals(promedio,7.333333333333333);
    }


}
