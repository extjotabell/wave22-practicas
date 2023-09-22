package com.mercadolibre.starwars.controller.testIntegracion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestIntegracion {
    @Autowired
    MockMvc mockMvc;

    @Test
    void findOk() throws Exception {
        String query = "Luke";
        List<CharacterDTO> expectedReturn = List.of(new CharacterDTO("Luke Skywalker",172,77,"blond","fair","blue","19BBY","male","Tatooine","Human"));

         ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

         String expected = mapper.writeValueAsString(expectedReturn);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(expected,mvcResult.getResponse().getContentAsString());

    }
}
