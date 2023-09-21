package com.meli.bookperfiles.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.bookperfiles.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllBook() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/books"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("¿Cómo programar en Java?"))
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
       // Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void getById() throws  Exception {

        mockMvc.perform(get("/books/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("¿Cómo programar en Java?"));
    }

    @Test
    void obtenerSaludo() throws Exception {

        mockMvc.perform(get("/books").param("name", "Belu"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello Belu"));
    }

    @Test
    void save() throws Exception {
        Book bookTest = new Book(3L,"Marina","Carlos Ruiz Zafón");

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();

        String jsonPayload = mapper.writeValueAsString(bookTest);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.author").value("Carlos Ruiz Zafón"));
    }


    @Test
    void saveConAssert() throws Exception {
        Book bookTest = new Book(3L,"Marina","Carlos Ruiz Zafón");
        Book bookResponse = new Book(3L,"Marina","Carlos Ruiz Zafón");

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(bookTest);
        String responseJson = mapper.writeValueAsString(bookResponse);

        MvcResult mvcResult = mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson,mvcResult.getResponse().getContentAsString());

    }


}
