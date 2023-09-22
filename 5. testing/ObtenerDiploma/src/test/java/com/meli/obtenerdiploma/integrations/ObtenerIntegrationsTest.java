package com.meli.obtenerdiploma.integrations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerIntegrationsTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoreExistUserWithHighAverage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(90.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno John Doe ha obtenido un promedio de 90. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    void analyzeScoreExistUserWithLowAverage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 6))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(8.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Mati Marin ha obtenido un promedio de 8. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(6));
    }

    @Test
    void analyzeScoreNonExistUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1323))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 1323 no se encuetra registrado."));
    }
}
