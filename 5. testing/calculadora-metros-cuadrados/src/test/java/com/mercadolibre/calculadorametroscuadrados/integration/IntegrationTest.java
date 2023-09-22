package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void calculateOkTest() throws Exception {

        RoomDTO room1 = new RoomDTO();
        room1.setName("room 1");
        room1.setLength(10);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("room 2");
        room2.setLength(5);
        room2.setWidth(2);

        HouseDTO body = new HouseDTO();
        body.setName("house");
        body.setAddress("Av. Siempre Viva 123");
        body.setRooms(List.of(room1, room2));

        HouseResponseDTO expected = new HouseResponseDTO(body);
        expected.setSquareFeet(60);
        expected.setBiggest(room1);
        expected.setPrice(48000);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(body)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expected)));
    }
}
