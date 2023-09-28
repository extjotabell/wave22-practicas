package com.example.be_java_hisp_w22_g02.integration.controller;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.ProductDto;
import com.example.be_java_hisp_w22_g02.service.Implementations.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIT {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserServiceImpl userService;
    PostDTO post;
    ProductDto productDto;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    void beforeEach() {
        post = new PostDTO();
        productDto = new ProductDto(1, "RandomProduct", "type", "brand", "color", "notes");
        post.setPostId(2);
        post.setCategory(1);
        post.setProduct(productDto);
        post.setDate(LocalDate.now());
        post.setPrice(10.0);
        post.setUserId(1);
    }

    @Test
    public void testAddNewPost() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(post)))
                .andDo(print())
                .andExpect(status().isOk());
        Mockito.verify(userService).addUserPost(any(PostDTO.class));
    }


}
