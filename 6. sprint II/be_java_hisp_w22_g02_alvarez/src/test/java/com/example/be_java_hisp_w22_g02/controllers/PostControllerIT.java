package com.example.be_java_hisp_w22_g02.controllers;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIT {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
            .writer();

    @Nested
    class AddPost {
        @Test
        void shouldReturnPostWhenAddUserPost() throws Exception {
            // ARRANGE
            ProductDto productDto = ProductDto.builder()
                    .productId(1)
                    .productName("Remera")
                    .type("Ropa")
                    .brand("Lacoste")
                    .color("Azul")
                    .notes("Ninguna")
                    .build();

            PostDTO postDTO = PostDTO.builder()
                    .postId(1)
                    .userId(1)
                    .date(LocalDate.parse("2023-09-27"))
                    .product(productDto)
                    .category(1)
                    .price(10.0)
                    .build();

            // ACT
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(writer.writeValueAsString(postDTO));

            ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
            ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(postDTO));

            // ASSERT
            mockMvc.perform(request)
                    .andExpect(statusExpected)
                    .andExpect(contentTypeExpected)
                    .andExpect(bodyExpected)
                    .andDo(MockMvcResultHandlers.print());

        }
    }

    @Nested
    class GetPosts {
        @Test
        void shouldResponseOkWhenGetPosts() throws Exception {

            // ARRANGE & ACT
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/1/list");
            ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            // ASSERT
            mockMvc.perform(request)
                    .andExpect(statusExpected)
                    .andExpect(contentTypeExpected)
                    .andDo(MockMvcResultHandlers.print());
        }
    }
}
