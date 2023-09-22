package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoresTest() throws Exception {
        long studentId = 2;
        double averageExpected = 7.333333333333333;
        mockMvc.perform(get("/analyzeScores/{studentId}",studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(studentId))
                .andExpect(jsonPath("$.averageScore").value(averageExpected));
    }
}
