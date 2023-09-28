package com.meli.be_java_hisp_w22_g01.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import com.meli.be_java_hisp_w22_g01.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T-INTEGRACIÓN ✅: Crear un post")
    void us0005Ok () throws Exception {
        ProductDTO productDTO = new ProductDTO(1, "Butaca","Gamer", "Race", "Black", "Special Edition");
        PostDTO postDTO = new PostDTO(1, 1, LocalDate.now(), productDTO,100,1500);
        String response = "Post creado con éxito";

        ObjectWriter mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(postDTO);

        mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(response));
    }
}
