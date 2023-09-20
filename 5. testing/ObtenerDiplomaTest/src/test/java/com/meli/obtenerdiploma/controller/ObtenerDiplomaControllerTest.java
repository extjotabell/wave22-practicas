package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ObtenerDiplomaControllerTest {

    @MockBean
    private ObtenerDiplomaService service;

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void analyzeScores() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        StudentDTO fakeResponse = new StudentDTO();
        Mockito.when(service.analyzeScores(anyLong())).thenReturn(fakeResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/analyzeScores/6"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(fakeResponse)));

    }
}