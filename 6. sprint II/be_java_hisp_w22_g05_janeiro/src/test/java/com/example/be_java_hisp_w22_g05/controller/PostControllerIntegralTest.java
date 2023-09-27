package com.example.be_java_hisp_w22_g05.controller;
import com.example.be_java_hisp_w22_g05.utils.PostGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.springframework.http.MediaType;
import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegralTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectWriter mapper;

    public PostControllerIntegralTest() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        this.mapper = objectMapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }


    @Nested
    class savePost{
        @Test
        @DisplayName("Save OK")
        void postSaveOkTest() throws Exception {
            PostGenerator postGenerator = new PostGenerator();
            ProductDto product = new ProductDto(5,"reloj","ropa","alguna","negro","asd");
            PostDto postDto = new PostDto(2, 2,LocalDate.now(),product,1,120.0,null,null);
            String jsonPayload = mapper.writeValueAsString(postDto);

            mockMvc.perform(post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonPayload))
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        @Test
        @DisplayName("Save product invalid param")
        void postSaveAlreadyExistsTest() throws Exception {
            PostGenerator postGenerator = new PostGenerator();
            ProductDto product = new ProductDto(1,"reloj","ropa","alguna","negro","asd");
            PostDto postDto = new PostDto(2, 2,LocalDate.now(),product,1,120.0,null,null);
            String jsonPayload = mapper.writeValueAsString(postDto);

            mockMvc.perform(post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonPayload))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.message").value("El producto con id 1 ya existe"));
        }

        @Test
        @DisplayName("Save product Already exists")
        void postSaveInvalidArgumentTest() throws Exception {
            PostGenerator postGenerator = new PostGenerator();
            ProductDto product = new ProductDto(1,"reloj","ropa","alguna","negro","asd");
            PostDto postDto = new PostDto(2, 0,LocalDate.now(),product,1,120.0,null,null);
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

    @Nested
    class ListPostFromSellers{

        @Test
        @DisplayName("list Posts from sellers OK")
        void listPostsFromSellersOkTest() throws Exception{
             mockMvc.perform(get("/products/followed/{userId}/list", "2"))
                    .andDo(print())
                    .andExpect(status().isOk())
                     .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.[0].post_id").value(1));
        }

        @Test
        @DisplayName("list Posts from sellers Not Found")
        void listPostsFromSellersNotFoundTest() throws Exception{
            mockMvc.perform(get("/products/followed/{userId}/list", "4"))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.message").value("No se encontró ningún post"));
        }
    }
}
