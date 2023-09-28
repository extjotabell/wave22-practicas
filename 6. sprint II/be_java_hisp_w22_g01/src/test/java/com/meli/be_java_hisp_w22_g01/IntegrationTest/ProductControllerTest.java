package com.meli.be_java_hisp_w22_g01.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import com.meli.be_java_hisp_w22_g01.dto.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper objectMapper;
    @BeforeAll
    static void SetUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void createPostOkTest() throws Exception {
        ProductDTO paramProd = new ProductDTO(123, "Tenedores", "Vajilla", "Tramontina", "Plata", "Tenedores por 6 unidades");

        PostDTO paramPost = new PostDTO(1,50,LocalDate.now(), paramProd,120,2000.00);

        ObjectWriter mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(paramPost)))
                .andExpect(status().isOk());

    }
    @Test
    void createPostTestFail() throws Exception {
        ProductDTO paramProd = new ProductDTO(123, "Tenedores", "Vajilla", "Tramontina", "Plata", "Tenedores por 6 unidades");

        PostDTO paramPost = new PostDTO(-1,50,LocalDate.now(), paramProd,120,2000.00);

        ObjectWriter mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(paramPost)))
                .andExpect(status().isBadRequest());

    }
}
