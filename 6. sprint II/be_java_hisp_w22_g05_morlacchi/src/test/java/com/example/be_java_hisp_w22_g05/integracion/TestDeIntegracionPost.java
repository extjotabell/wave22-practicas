package com.example.be_java_hisp_w22_g05.integracion;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestDeIntegracionPost {
    static PostDto post;
    @BeforeAll
    static void setup(){
        ProductDto product = new ProductDto(5,"Silla","Gamer","Racer","Red","Special");
        post = new PostDto(2,1,LocalDate.now(),product,100,1000.00,true,0.25);
    }
    @Autowired
    MockMvc mockMvc;

    ObjectWriter mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    @DisplayName("US0005: newPost")
    void newPost() throws Exception{
        //ARRANGER
        String payload = mapper.writeValueAsString(post);

        //ACT & ASSERTION
        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US0006: getListPostsFromSellersFollowed")
    void getListPostsFromSellersFollowed() throws Exception{
        //ARRANGER
        List<PostDto> expected = List.of(post);
        String result = mapper.writeValueAsString(expected);

        //ACT & ASSERTION
        mockMvc.perform(post("/products/followed/{userId}/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(result));
    }
}
