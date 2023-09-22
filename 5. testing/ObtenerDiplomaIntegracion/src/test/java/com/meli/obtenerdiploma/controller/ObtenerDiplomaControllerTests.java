package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        StudentDTO expected = controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    void obtenerDiplomaIntegrationTestOk() throws Exception{
        List<SubjectDTO> listSubject = List.of(new SubjectDTO("Lengua",10.0), new SubjectDTO("Fisica",8.0), new SubjectDTO("Quimica",4.0));
        StudentDTO stu = new StudentDTO(1L,"Pedro","El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.",7.333333333333333,listSubject);
        String expected = mapper.writeValueAsString(stu);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));


    }

    @Test
    void obtenerDiplomaIntegrationFail() throws Exception{
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException","El alumno con Id 3 no se encuetra registrado.");
        String expected = mapper.writeValueAsString(errorDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","3"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));


    }

}
