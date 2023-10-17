package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
 class CalculateServiceTest {
    static CalculateService calculateService;
    static HouseDTO sampleHouse;
    static HouseResponseDTO houseResponseDTO;

    @BeforeAll
    static void setUp(){
        calculateService = new CalculateService();
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
        houseResponseDTO.setPrice(52800);
        houseResponseDTO.setSquareFeet(90000);
    }
    @Test
    void calculate_test(){
        HouseResponseDTO response = calculateService.calculate(sampleHouse);
        Assertions.assertEquals(houseResponseDTO.getPrice(), response.getPrice());
    }
}
