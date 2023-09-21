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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    /*
    Ejercicio 2
    Test Unitarios con Mocks
    Se requiere crear los tests unitarios necesarios para cubrir el comportamiento
    de la capa de servicios ObtenerDiplomaService. Tener en cuenta múltiples escenarios
    y “casos borde” de cada comportamiento.
    Casos nulos, vacíos, inválidos.
    Datos de Salida idénticos a datos de Entrada.
    Cálculo del Promedio.
    Leyenda del Diploma.
    Mensaje de Diploma con Honores.
    Pasos del test Unitario con Mocks
    Crear el mock IStudentDAO.
    Inyectarlo en ObtenerDiplomaService.
    Configurar su comportamiento (setup) con el método when.
    Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.
     */

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresTest(){

        // ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Mario Roberto", 10.0));
        subjectDTOList.add(new SubjectDTO("Jose de San Martin", 9.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Nombre", "", 8.5, subjectDTOList);

        // ACT
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        // ASSERT
        // AnalyzeScore le pone un mensaje de felicitaciones al student,
        // por lo que el message del student que creamos deja de estar vacio
        assertNotEquals("", obtenerDiplomaService.analyzeScores(1L).getMessage());
    }

    @Test
    void AnalizeScoreNotNull(){
        //Arrage
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("lengua",6.5));
        StudentDTO student = new StudentDTO(10L ,"Ale", "hola", 8.5, subjectDTOList);StudentDTO studentDTO=new StudentDTO();
        StudentDTO expected = student;

        //ACT

        Mockito.when(studentDAO.findById(student.getId())).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(student.getId());

        //ASSERT

        assertEquals(expected,result);


    }
    @Test
    void analyzeScoreAverage9() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Mario Roberto", 10.0));
        subjectDTOList.add(new SubjectDTO("Jose de San Martin", 10.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Nombre", "", 9.0, subjectDTOList);
        String expectedMessage = "Felicitaciones!";

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        String resultMessage = obtenerDiplomaService.analyzeScores(1L).getMessage();

        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    void analyzeScoreAverageLessThan9() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Mario Roberto", 7.0));
        subjectDTOList.add(new SubjectDTO("Jose de San Martin", 7.0));
        StudentDTO studentDTO = new StudentDTO(1L, "Nombre", "", 9.0, subjectDTOList);
        String expectedMessage = "Puedes mejorar.";

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        String resultMessage = obtenerDiplomaService.analyzeScores(1L).getMessage();

        assertTrue(resultMessage.contains(expectedMessage));
    }


}


