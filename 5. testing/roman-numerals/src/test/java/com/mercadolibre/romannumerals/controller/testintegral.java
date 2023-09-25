package com.mercadolibre.romannumerals.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class testintegral {
    @Autowired
    MockMvc mockMvc;

    @Test
    void toRomanTest()  throws Exception {
        MvcResult mvcResult =  mockMvc.perform(get("/{number}",7))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(),"VII");

    }
}
