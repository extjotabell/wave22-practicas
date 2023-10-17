package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ITObtenerDiplomaController {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ObtenerDiplomaService obtenerDiplomaService;
    private static ObjectMapper mapper;
    private static ObjectWriter writer;
    StudentDTO studentDTO;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void beforeEach() {
        studentDTO = new StudentDTO();
        studentDTO.setStudentName("Name");
        studentDTO.setId(1L);
        studentDTO.setMessage("message");
        studentDTO.setSubjects(List.of(new SubjectDTO()));
        studentDTO.setAverageScore(10.9);
        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);
    }

    @Test
    @DisplayName("1-AnalyzeScore OK Test")
    void analyzeScores_test_ok() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        StudentDTO responseStudent = mapper.readValue(jsonResponse, StudentDTO.class);
        Mockito.verify(obtenerDiplomaService).analyzeScores(any(Long.class));
        assertNotNull(responseStudent);
        assertEquals("Name", responseStudent.getStudentName());
    }



}
