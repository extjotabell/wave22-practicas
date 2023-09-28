package com.meli.be_java_hisp_w22_g01.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T-INTEGRACIÓN ✅: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor")
    void us0002OK() throws  Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.user_name").value("Rick Harrison"))
                .andExpect(jsonPath("$.followers").value("2"));
    }

    @Test
    @DisplayName("T-INTEGRACIÓN 🚫:  El usuario no existe")
    void usOOO2Fail() throws  Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", "4"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encontró el usuario con id: 4"));
    }
}
