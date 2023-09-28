package com.example.be_java_hisp_w22_g05.integration_tests;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
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

import static com.example.be_java_hisp_w22_g05.utils.PostGenerator.getPostDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration US0005 - Create a new post OK")
    void postSaveOkTest() throws Exception {
        PostDto postDto = getPostDto();
        ObjectWriter mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration US0005 - Create a new post Not OK")
    void postSaveSadTest() throws Exception {
        PostDto postDto = getPostDto();
        postDto.setUserId(-1);
        ObjectWriter mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.explanation").value("Se encontraron los siguientes errores en las validaciones: "));
    }
}
