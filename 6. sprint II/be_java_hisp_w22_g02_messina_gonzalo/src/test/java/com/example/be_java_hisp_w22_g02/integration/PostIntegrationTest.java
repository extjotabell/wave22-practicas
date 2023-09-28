package com.example.be_java_hisp_w22_g02.integration;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getLastTwoWeeksPostByUserFollowed() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/1/list"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void addNewPost() throws Exception{
        LocalDate  date = LocalDate.parse("2022-11-10");
        ProductDto productDto = new ProductDto(1,"Laptop","Tecnologia","HP","Negro","Procesador Intel Core");
        PostDTO postDTO = new PostDTO(1,1,date,productDto,1,1000);

        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        String payloadJson = writer.writeValueAsString(postDTO);

        MvcResult mvcResult = mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                //.andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
    }

}
