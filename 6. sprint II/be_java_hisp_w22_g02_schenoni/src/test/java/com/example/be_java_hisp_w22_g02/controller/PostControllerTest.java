package com.example.be_java_hisp_w22_g02.controller;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Add new post")
    void addNewPost() throws Exception {
        ProductDto productDto = new ProductDto(1, "Remera", "Ropa", "Marca", "Negro", "La mejor remara del mundo!, no se ensucia nunca");
        PostDTO postDto = new PostDTO(1, 1, LocalDate.now(), productDto, 1, 99.99);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(postDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        assertEquals(payloadDto,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get last two weeks post by user followed id")
    void getLastTwoWeeksPostByUserFollowed() throws Exception {
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1);

        MvcResult mvcResult = mockMvc.perform(request)
                .andDo(print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andReturn();
    }
}