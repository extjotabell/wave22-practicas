package com.meli.be_java_hisp_w22_g01.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.ExceptionDTO;
import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import com.meli.be_java_hisp_w22_g01.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US0005 ✅: Dar de alta una nueva publicación")
    void testUS0005Ok() throws Exception {
        String endpoint = "/products/post";
        int userId = 4;
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        PostDTO payload = new PostDTO(3, 1, LocalDate.of(2023, 9, 28), new ProductDTO(1, "Botella", "Tipo", "Genérica", "Rojo", "Notas"), 63, 2543.0);

        String jsonPayload = writer.writeValueAsString(payload);

        mockMvc.perform(post(endpoint, userId).contentType(MediaType.APPLICATION_JSON).content(jsonPayload))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("US0005 🚫: Error de validación: Id negativo")
    void testUS0005Fail() throws Exception {
        String endpoint = "/products/post";
        int userId = 4;
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        PostDTO payload = new PostDTO(-1, 1, LocalDate.of(2023, 9, 28), new ProductDTO(1, "Botella", "Tipo", "Genérica", "Rojo", "Notas"), 63, 2543.0);

        ExceptionDTO expectedResponse = new ExceptionDTO("El id debe ser mayor a 0.");

        String jsonPayload = writer.writeValueAsString(payload);
        String jsonExpectedResponse = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(post(endpoint, userId).contentType(MediaType.APPLICATION_JSON).content(jsonPayload))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(jsonExpectedResponse))
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US0005 🚫: Error de validación: Id negativo y carácteres especiales")
    void testUS0005Fail2() throws Exception {
        // ARRANGE
        String endpoint = "/products/post";
        int userId = 4;

        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        PostDTO payload = new PostDTO(-1, 1, LocalDate.of(2023, 9, 28), new ProductDTO(1, "Botella", "Tipo$$$", "Genérica", "Rojo", "Notas"), 63, 2543.0);

        ExceptionDTO expectedResponse = new ExceptionDTO(List.of("El id debe ser mayor a 0.", "El campo no puede poseer caracteres especiales."));

        String jsonPayload = writer.writeValueAsString(payload);
        String jsonExpectedResponse = writer.writeValueAsString(expectedResponse);

        // ACT & ASSERT
        mockMvc.perform(post(endpoint, userId).contentType(MediaType.APPLICATION_JSON).content(jsonPayload))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(jsonExpectedResponse))
                .andDo(print())
                .andReturn();
    }
}
