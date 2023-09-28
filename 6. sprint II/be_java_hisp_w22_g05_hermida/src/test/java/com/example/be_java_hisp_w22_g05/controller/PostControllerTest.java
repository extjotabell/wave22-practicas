package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule()).writer();

    /**
     * Integration test to successfully save a new post
     */
    @Test
    @DisplayName("Nuevo post OK")
    void savePostOk() throws Exception {

        ProductDto productDto = new ProductDto(5, "Name", "Type", "Brand", "Color", "Notes");

        PostDto input = new PostDto(1, 1, LocalDate.now(), productDto, 10, 2500.00, false, null);

        String payload = writer.writeValueAsString(input);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(status().isOk());

    }

    /**
     * Integration test for when a user tries to save a new post with validation errors
     */
    @Test
    @DisplayName("Post error validaciones")
    void savePostValidationError() throws Exception{
        ProductDto productDto = new ProductDto(1, "Name", "Type", "Brand", "Color", "Notes");

        PostDto input = new PostDto(1, 0, null, productDto, 0, 11000000.00, false, null);

        String payload = writer.writeValueAsString(input);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.explanation").value("Se encontraron los siguientes errores en las validaciones: "));
    }

    /**
     * Integration test for when a user tries to save a post with an existing product id
     */
    @Test
    @DisplayName("Post id producto ya existe")
    void savePostProductExists() throws Exception {
        ProductDto productDto = new ProductDto(1, "Name", "Type", "Brand", "Color", "Notes");

        PostDto input = new PostDto(1, 1, LocalDate.now(), productDto, 10, 2500.00, false, null);

        String payload = writer.writeValueAsString(input);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El producto con id " + productDto.getId() + " ya existe"));
    }


}
