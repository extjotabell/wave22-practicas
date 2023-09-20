package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    static StudentDTO studentDTO;
    @BeforeAll
    static void setup(){
        SubjectDTO materia1 = new SubjectDTO("Química", 7.8);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        studentDTO = new StudentDTO(4L, "Carlos", null, null, listaDeMaterias);
    }

    @Mock
    IStudentDAO dao;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    void calculateAverageOkTest(){

        when(dao.findById(any())).thenReturn(studentDTO);

        StudentDTO serviceResponse = service.analyzeScores(any());
        Assertions.assertEquals(serviceResponse.getAverageScore(), 8.1);
    }

    @Test
    void getMessageOkTest(){

        when(dao.findById(any())).thenReturn(studentDTO);
        StudentDTO serviceResponse = service.analyzeScores(any());
        Assertions.assertEquals(serviceResponse.getMessage(), "El alumno Carlos ha obtenido un promedio de "+ (7.8 + 8.4)/2 + ". Puedes mejorar.");
    }


}
