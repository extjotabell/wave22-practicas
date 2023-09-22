package com.mercadolibre.calculadorametroscuadrados.integrationTesting;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void calculateTestOk() throws Exception{
        ObjectWriter mapper = new ObjectMapper()
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
                .writer();

        RoomDTO room1 = new RoomDTO("Kitchen", 10, 10);
        RoomDTO room2 = new RoomDTO("Living", 50, 50);
        RoomDTO room3 = new RoomDTO("Bathroom", 5, 5);
        List<RoomDTO> rooms = List.of(room1, room2, room3);
        HouseDTO house = new HouseDTO("House", "AD7", rooms);

        HouseResponseDTO houseExpected = new HouseResponseDTO(house);
        houseExpected.setSquareFeet(2625);
        houseExpected.setPrice(2100000);
        houseExpected.setBiggest(room2);

        String payload = mapper.writeValueAsString(house);
        ResultMatcher expected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(houseExpected));


        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(expected);
    }
}
