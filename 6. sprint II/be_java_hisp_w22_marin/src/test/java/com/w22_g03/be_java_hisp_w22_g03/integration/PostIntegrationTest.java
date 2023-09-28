package com.w22_g03.be_java_hisp_w22_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {
    @Autowired
    private MockMvc mockMvc;



    @Test
    void addPostOk () throws Exception {
        LocalDate date = LocalDate.of(2023, 8, 26);
        ProductDTO productDTO = new ProductDTO(1L, "Producto", "Raro" , "Pre", "psd", "ds");

        PostDTO postDTO = new PostDTO();
        postDTO.setDate(date);
        postDTO.setProduct(productDTO);
        postDTO.setUserId(1L);
        postDTO.setCategory(12);
        postDTO.setPrice(124.32);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(postDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product.product_id").value(1))
                .andDo(print());
    }

     @Test
    void addPostInvalidField () throws Exception {
        LocalDate date = LocalDate.of(2023, 8, 26);
        ProductDTO productDTO = new ProductDTO(1L, "Producto", "Raro" , "Pre", "psd", "ds");

        PostDTO postDTO = new PostDTO();
        postDTO.setDate(date);
        postDTO.setProduct(productDTO);
        postDTO.setUserId(1L);


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(postDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    void getFollowedListInvalidOrder () throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list?order=name_asc", 1))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[0]").value("Orden no válido, Solamente acepta date_asc o date_desc"))
                .andDo(print());
    }

    @Test
    void getFollowedListWithOutOrder () throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].user_id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].post_id").value(2))
                .andDo(print());
    }

}
