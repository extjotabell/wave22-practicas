package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTestIntegral {

    @Autowired
    MockMvc mockMvc;

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;



    @Test
    void GetPersonajeTest() throws Exception {

        List<CharacterDTO> characterDTOS = new ArrayList<>(List.of(
                new CharacterDTO(    "Darth Vader","none","white","yellow","41.9BBY","male", "Tatooine","Human",202,136),
                new CharacterDTO(    "Darth Maul","none","red","yellow","54BBY","male", "Dathomir","Zabrak",175,80)
        ));

        MvcResult result = mockMvc.perform(get("/{query}", "Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        List<CharacterDTO> resultDto = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<CharacterDTO>>() {
        });
        Assertions.assertEquals(characterDTOS, resultDto);
    }
}
