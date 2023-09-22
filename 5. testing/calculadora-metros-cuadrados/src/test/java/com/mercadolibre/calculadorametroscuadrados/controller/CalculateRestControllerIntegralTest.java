package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtilGenerator.getHouse0Room;
import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtilGenerator.getHouse2Room;


import static jdk.dynalink.linker.support.Guards.isNull;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegralTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    void CalculateHouseOkTest() throws Exception {
        HouseDTO house = getHouse2Room();

        String jsonPayload = mapper.writeValueAsString(house);

         mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                 .andExpect(jsonPath("$.squareFeet").value("160"))
                 .andExpect(jsonPath("$.price").value("128000"))
                 .andExpect(jsonPath("$.biggest.name").value("Habitacion de Lisa"));

    }

    @Test
    void CalculateHouse0RoomsTest() throws Exception {
        HouseDTO house = getHouse0Room();

        String jsonPayload = mapper.writeValueAsString(house);

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet").value("0"))
                .andExpect(jsonPath("$.price").value("0"))
                .andExpect(jsonPath("$.biggest").value(nullValue()));

    }

    @Test
    void CalculateHouseEmptyBodyTest() throws Exception {;
        HouseDTO house = new HouseDTO();
        String jsonPayload = mapper.writeValueAsString(house);

        mockMvc.perform(post("/calculate"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }
}
