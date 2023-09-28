package com.meli.be_java_hisp_w22_g01.intTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.PostDto;
import com.meli.be_java_hisp_w22_g01.dto.ProductDto;
import com.meli.be_java_hisp_w22_g01.exceptions.BadRequestException;
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
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer= new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    @Test
    void createPost_OK() throws Exception{

        //Arrange
        PostDto param = new PostDto(1,1, LocalDate.now(),new ProductDto(1,"silla","2","c","rojo","nueva"),1,230);

        String payloadJson = this.writer.writeValueAsString(param);

        //Act Assert
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());


    }
    @Test
    void createPost_NotOkID() throws Exception{

        //Arrange
        PostDto param = new PostDto(0,1, LocalDate.now(),new ProductDto(1,"silla","2","c","rojo","nueva"),2,10);

        String payloadJson = this.writer.writeValueAsString(param);

        //Act Assert
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El id debe ser mayor a 0."));


    }
    @Test
    void createPost_NotOkPrice() throws Exception{

        //Arrange
        PostDto param = new PostDto(1,1, LocalDate.now(),new ProductDto(1,"silla","2","c","rojo","nueva"),2,111111111);

        String payloadJson = this.writer.writeValueAsString(param);

        //Act Assert
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El precio máximo por producto es de 10.000.000."));


    }
}
