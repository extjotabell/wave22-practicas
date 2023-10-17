package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
 class CalculateControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    CalculateRestController calculateRestController;
    @Mock
    CalculateService calculateService;
    static HouseDTO sampleHouse;
    static HouseResponseDTO houseResponseDTO;
    static ObjectMapper mapper;
    static ObjectWriter writer;

    @BeforeAll
    static void setUp(){
        writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer().withDefaultPrettyPrinter();
        mapper = new ObjectMapper();
        sampleHouse = new HouseDTO();
        sampleHouse.setName("Casa");
        sampleHouse.setAddress("Calle 123");

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO livingRoom = new RoomDTO();
        livingRoom.setName("Living Room");
        livingRoom.setWidth(5);
        livingRoom.setLength(6);
        rooms.add(livingRoom);

        RoomDTO kitchen = new RoomDTO();
        kitchen.setName("Kitchen");
        kitchen.setWidth(4);
        kitchen.setLength(5);
        rooms.add(kitchen);

        RoomDTO bedroom = new RoomDTO();
        bedroom.setName("Bedroom");
        bedroom.setWidth(4);
        bedroom.setLength(4);
        rooms.add(bedroom);

        sampleHouse.setRooms(rooms);

        houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setBiggest(livingRoom);
        houseResponseDTO.setPrice(50000);
        houseResponseDTO.setSquareFeet(90000);
    }
    @Test
    void calculate_test() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate")
                .content(writer.writeValueAsString(sampleHouse))
                        .contentType(MediaType.APPLICATION_JSON)
                        ).andDo(print())
                .andExpect(status().isOk());
    }
}
