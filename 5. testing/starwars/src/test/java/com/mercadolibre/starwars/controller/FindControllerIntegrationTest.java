package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void find() throws Exception {
        //Arrange
        String query = "Luke Skywalker";
        CharacterDTO lukeSkywalker = new CharacterDTO("Luke Skywalker","blond", "fair","blue","19BBY", "male","Tatooine", "Human", 172, 77);
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJsonResponse = mapper.writeValueAsString(List.of(lukeSkywalker));
        //Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/{query}",query))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        //Assert

        Assertions.assertEquals(expectedJsonResponse,mvcResult.getResponse().getContentAsString());
    }
}
