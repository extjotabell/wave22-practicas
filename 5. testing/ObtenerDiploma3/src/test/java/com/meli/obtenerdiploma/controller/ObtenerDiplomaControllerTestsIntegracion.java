package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTestsIntegracion {

    @Autowired
    MockMvc mockMvc;

    @Test
    void obtenerDiploma() throws Exception {

        ObjectWriter mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value("7.333333333333333"));
    }

    @Test
    void obtenerDiplomaNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","5"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"));
    }

}
