package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    CharacterRepositoryImpl repository;

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findMockMvc() throws Exception{

        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(new CharacterDTO("Luke Skywalker", "blond", "fair","blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        String query = "Luke";

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].hair_color").value(characters.get(0).getHair_color()));

    }

    @Test
    void findUnitTest(){
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(new CharacterDTO("Luke Skywalker", "blond", "fair","blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        String query = "Luke";

        when(repository.findAllByNameContains(query)).thenReturn(characters);
        when(service.find(query)).thenReturn(characters);

        Assertions.assertEquals(controller.find(query), characters);

    }

}
