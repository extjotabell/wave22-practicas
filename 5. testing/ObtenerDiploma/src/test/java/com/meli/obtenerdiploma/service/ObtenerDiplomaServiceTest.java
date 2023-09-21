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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


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


}
