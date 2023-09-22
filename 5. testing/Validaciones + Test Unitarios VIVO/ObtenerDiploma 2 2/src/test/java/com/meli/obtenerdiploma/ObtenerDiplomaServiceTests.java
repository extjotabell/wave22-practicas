package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO dao;

    @InjectMocks
    ObtenerDiplomaService underTest;

    @Test
    void calculateAverageOkTest(){
        SubjectDTO materia1 = new SubjectDTO("Química", 7.8);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        StudentDTO expected = new StudentDTO(10L, "Carlos", null, null, listaDeMaterias);

        when(dao.findById(10L)).thenReturn(expected);

        StudentDTO serviceResponse = underTest.analyzeScores(10L);
        Assertions.assertEquals(8.1, serviceResponse.getAverageScore());
    }

    @Test
    void getMessageOkTest(){
        SubjectDTO materia1 = new SubjectDTO("Química", 8.0);
        SubjectDTO materia2 = new SubjectDTO("Física", 8.4);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        StudentDTO expected = new StudentDTO(10L, "Carlos", null, null, listaDeMaterias);

        when(dao.findById(10L)).thenReturn(expected);
        StudentDTO serviceResponse = underTest.analyzeScores(10L);
        Assertions.assertEquals(serviceResponse.getMessage(), "El alumno Carlos ha obtenido un promedio de "+ (8.0 + 8.4)/2 + ". Puedes mejorar.");
    }

    @Test
    void getCongratsMessageOkTest(){
        SubjectDTO materia1 = new SubjectDTO("Química", 10.0);
        SubjectDTO materia2 = new SubjectDTO("Física", 9.0);
        List<SubjectDTO> listaDeMaterias = new ArrayList<>();
        listaDeMaterias.add(materia1);
        listaDeMaterias.add(materia2);
        StudentDTO expected = new StudentDTO(10L, "Carlos", null, null, listaDeMaterias);

        when(dao.findById(10L)).thenReturn(expected);
        StudentDTO serviceResponse = underTest.analyzeScores(10L);
        Assertions.assertEquals(serviceResponse.getMessage(), "El alumno Carlos ha obtenido un promedio de "+ (10.0 + 9.0)/2 + ". Felicitaciones!");
    }

}
