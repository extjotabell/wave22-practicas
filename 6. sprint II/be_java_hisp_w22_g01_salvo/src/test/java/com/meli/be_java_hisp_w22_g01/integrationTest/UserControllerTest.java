package com.meli.be_java_hisp_w22_g01.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US0004 ✅: Obtener lista de vendedores que sigue un usuario")
    void testUS0004Ok() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followed/list";
        int userId = 4;

        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_name").value("Lisa"))
                .andExpect(jsonPath("$.followed[0].user_name").value("Rick Harrison"))
                .andDo(print());
    }@Test
    @DisplayName("US0004 🚫: Usuario no existe")
    void testUS0004Fail() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followed/list";
        int userId = 400;

        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message[0]").value("No existe el usuario"))
                .andDo(print());
    }
}
