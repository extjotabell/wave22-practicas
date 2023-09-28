package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.example.be_java_hisp_w22_g05.utils.PostGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;



import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();


    @Test
    void postSaveOkTest() throws Exception{
        //Arrange
        ProductDto productDto = new ProductDto(3,"reloj","ropa","alguna","negro","");
        PostDto newPost = new PostDto(1, 1, LocalDate.now().minusDays(13), productDto, 1,  200.0, null, null);
        PostDto expected = new PostDto(1, 1, LocalDate.now().minusDays(13), productDto, 1,  200.0, null, null);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String payload = mapper.writeValueAsString(newPost);
        String expectedJson = mapper.writeValueAsString(expected);

        //Act
        mockMvc.perform(post("/products/post")
                        . contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc"})
    void getListPostsFromSellersFollowed(String order) throws Exception {
        // ARRANGE
       int userId = 1;
       String expectedJsonResponse = objectMapper.writeValueAsString(
                order.equals("date_asc") ? PostGenerator.getPostDtoListAsc() : PostGenerator.getPostDtoListDesc()
       );
        // ACT
        MvcResult mvcResult =  mockMvc.perform(get("/products/followed/{userId}/list", userId).param("order", order))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // ASSERT
        assertEquals(expectedJsonResponse, mvcResult.getResponse().getContentAsString());
    }


    @Test
    void getListPostsFromSellersFollowedTest() throws Exception {
        final int userId = 1;
        final int followedUserId = 4;

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user_id").value(followedUserId));

    }

    @Test
    void getListPostsFromSellersFollowedNotFoundTest() throws Exception {
        final int userId = 5;
        final String expectedMessageValue = "No se encontró ningún post";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessageValue));
    }

    @Test
    void getListPostsFromSellersFollowedInvalidOrderTest() throws Exception {
        final int userId = 1;
        final String invalidOrder = "orderes";
        final String expectedMessageValue = "Request param invalido, opciones validas: <date_asc> o <date_desc>";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", invalidOrder)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(expectedMessageValue));
    }


}