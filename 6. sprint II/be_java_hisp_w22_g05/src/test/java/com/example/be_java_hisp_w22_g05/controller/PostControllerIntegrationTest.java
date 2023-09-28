package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Integration test for get list post OK")
    void getListPostsFromSellersFollowedOkTest() throws Exception {
        final int userId = 2;
        final int followedUserId = 1;

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user_id").value(followedUserId));

    }

    @Test
    @DisplayName("Integration test for get list post not found")
    void getListPostsFromSellersFollowedNotFoundTest() throws Exception {
        final int userId = 1;
        final String expectedMessageValue = "No se encontró ningún post";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessageValue));
    }

    @Test
    @DisplayName("Integration test for get list post invalid Order")
    void getListPostsFromSellersFollowedInvalidOrderTest() throws Exception {
        final int userId = 2;
        final String invalidOrder = "XXXX";
        final String expectedMessageValue = "Request param invalido, opciones validas: <date_asc> o <date_desc>";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", invalidOrder)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(expectedMessageValue));
    }

    @Test
    @DisplayName("Integration test for new post")
    void newPostOkTest() throws Exception {
        final var productDto = new ProductDto(100,"celular","electro","samsung","negro","");
        final var postDto = new PostDto(1,1, LocalDate.of(2023,9,18), productDto, 1,200.0,false,0.0);
        final String postDtoJson = objectMapper.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDtoJson))
                .andExpect(status().isOk());
    }
}
