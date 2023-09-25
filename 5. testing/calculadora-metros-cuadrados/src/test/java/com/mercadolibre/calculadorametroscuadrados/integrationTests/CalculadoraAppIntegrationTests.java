package com.mercadolibre.calculadorametroscuadrados.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraAppIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void calculateEndpointOk() throws Exception {
        // Arrenge
        RoomDTO room1 = new RoomDTO();
        room1.setName("Habitacion"); // No convierte correctamente los caracteres especiales (ó)
        room1.setLength(10);
        room1.setWidth(20);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Bano"); // No convierte correctamente los caracteres especiales (ñ)
        room2.setLength(5);
        room2.setWidth(10);

        HouseDTO houseSentDTO = new HouseDTO();
        houseSentDTO.setName("Casinha");
        houseSentDTO.setAddress("Av. Siempre Viva 123");
        houseSentDTO.setRooms(List.of( room1, room2));

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseSentDTO);
        houseResponseDTO.setBiggest(room1);
        houseResponseDTO.setSquareFeet(250);
        houseResponseDTO.setPrice(200000);

        ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

        String jsonPayload = mapper.writeValueAsString(houseSentDTO);
        String expected = mapper.writeValueAsString(houseResponseDTO);

        // Act
        MvcResult result = mockMvc.perform(
            MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void calculateEndpointEmptyFail() throws Exception {
        Object nullObj = null;
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(""))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void calculateEndpointBadJsonFail() throws Exception {
        // Arrenge
        RoomDTO room1 = new RoomDTO();
        room1.setName("Habitacion"); // No convierte correctamente los caracteres especiales (ó)
        room1.setLength(10);
        room1.setWidth(20);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Bano"); // No convierte correctamente los caracteres especiales (ñ)
        room2.setLength(5);
        //room2.setWidth(10); // Sets eliminados para tener una request incompleta

        HouseDTO houseSentDTO = new HouseDTO();
        //houseSentDTO.setName("Casinha"); // Sets eliminados para tener una request incompleta
        //houseSentDTO.setAddress("Av. Siempre Viva 123"); // Sets eliminados para tener una request incompleta
        houseSentDTO.setRooms(List.of( room1, room2));

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseSentDTO);
        houseResponseDTO.setBiggest(room1);
        houseResponseDTO.setSquareFeet(250);
        houseResponseDTO.setPrice(200000);

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(houseSentDTO);
        String expected = mapper.writeValueAsString(houseResponseDTO);

        // Act
        // Assert
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonPayload))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

}
