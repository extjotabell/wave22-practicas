package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void findOkTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        MvcResult obtainedResult = mockMvc.perform(get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String obtainedResultAsString = obtainedResult.getResponse().getContentAsString();

        List<CharacterDTO> obtainedResultMapped = objectMapper.readValue(obtainedResultAsString, new TypeReference<>() {});

        Assertions.assertEquals("Luke Skywalker", obtainedResultMapped.get(0).getName());
    }

    @Test
    void findOkAlternativeTest() throws Exception {
        mockMvc.perform(get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", equalTo("Luke Skywalker")));
    }

    @Test
    void findEmptyTest() throws Exception {
        mockMvc.perform(get("/{query}","XXXX"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }
    
}
