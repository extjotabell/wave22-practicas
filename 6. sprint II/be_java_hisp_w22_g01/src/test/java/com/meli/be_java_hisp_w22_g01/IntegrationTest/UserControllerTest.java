package com.meli.be_java_hisp_w22_g01.IntegrationTest;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName(" ✅ Cantidad de usuarios seguidores de un vendedor. ")
    void countFollowersOkTest() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").value(2));
    }

    @Test
    @DisplayName(" 🚫 No se encontró un vendedor con ese id. ")
    void countFollowersFailTest() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count",4))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontró el usuario con id: 4"));
    }
}
