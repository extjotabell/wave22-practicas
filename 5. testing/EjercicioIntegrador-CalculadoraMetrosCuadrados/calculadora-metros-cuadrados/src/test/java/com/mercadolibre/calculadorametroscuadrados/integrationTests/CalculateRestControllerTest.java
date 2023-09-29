package com.mercadolibre.calculadorametroscuadrados.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void calculateOkTest() throws Exception
    {
        List<RoomDTO> roomList = new ArrayList<>();
        HouseDTO house = new HouseDTO();
        house.setAddress("Calle fasa 123");
        house.setName("Casa");

        RoomDTO room = new RoomDTO();
        room.setName("Habitacion");
        room.setLength(4);
        room.setWidth(4);

        RoomDTO banio = new RoomDTO();
        room.setName("Banio");
        room.setLength(2);
        room.setWidth(2);


        roomList.add(room);
        roomList.add(banio);
        house.setRooms(roomList);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(house);

        mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
