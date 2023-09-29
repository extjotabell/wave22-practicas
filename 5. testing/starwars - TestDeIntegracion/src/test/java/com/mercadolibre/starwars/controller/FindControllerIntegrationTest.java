package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void findTestOk() throws Exception
    {
        MvcResult mvcResult = mockMvc.perform(get("/Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    void findTestEmpty() throws Exception
    {
        MvcResult mvcResult = mockMvc.perform(get("/asd"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("application/json",mvcResult.getResponse().getContentType());
    }
}
