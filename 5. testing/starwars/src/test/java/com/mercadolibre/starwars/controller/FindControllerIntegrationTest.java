package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter mapper;

    @BeforeEach
    void setUp(){
        mapper = new ObjectMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void findTestOk() throws Exception{
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));

        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(characterDTOList));

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(contentExpected);
    }

    @Test
    void findTestEmpty() throws Exception{
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(List.of()));

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "asdasdas"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(contentExpected);
    }
}
