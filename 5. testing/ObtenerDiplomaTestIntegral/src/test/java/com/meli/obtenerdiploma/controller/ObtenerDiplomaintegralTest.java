package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaintegralTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoresTest() throws Exception{

        mockMvc.perform(get("/analyzeScores/{studentId}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.message" , containsString("7.33")))
                .andExpect(jsonPath("$.averageScore").value(7.333333333333333))
                .andExpect(jsonPath("$.subjects").exists());
    }

    @Test
    void analyzeScoresErrorTest() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}",5L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description" , containsString("5")));

    }
}
