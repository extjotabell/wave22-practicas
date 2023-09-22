package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("test: Calculate House with two rooms")
    void calculateHouseWith2Rooms() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        HouseDTO houseDTO = getHouseDTO();

        String payload = writer.writeValueAsString(houseDTO);

        this.mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet").value(125))
                .andExpect(jsonPath("$.price").value(100000))
                .andExpect(jsonPath("$.name").value("House2Rooms"))
        ;

    }

    @Test
    @DisplayName("test: Calculate House with no rooms")
    void calculateNoRoomsHouse() throws Exception{
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        HouseDTO houseDTO = getHouseDTO();
        houseDTO.setRooms(List.of());
        houseDTO.setName("NullHouse");

        String payload = writer.writeValueAsString(houseDTO);

        this.mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet").value(0))
                .andExpect(jsonPath("$.price").value(0))
                .andExpect(jsonPath("$.name").value("NullHouse"))
        ;

    }

    private static HouseDTO getHouseDTO() {
        HouseDTO houseDTO = new HouseDTO();
        RoomDTO roomBiggest = new RoomDTO();
        RoomDTO roomSmaller = new RoomDTO();
        //Rooms
        roomBiggest.setName("RoomBiggest");
        roomBiggest.setLength(10);
        roomBiggest.setWidth(10);
        roomSmaller.setName("RoomSmaller");
        roomSmaller.setLength(5);
        roomSmaller.setWidth(5);
        //House
        houseDTO.setAddress("AddressHouse2Rooms");
        houseDTO.setName("House2Rooms");
        houseDTO.setRooms(List.of(roomBiggest, roomSmaller));
        return houseDTO;
    }


}