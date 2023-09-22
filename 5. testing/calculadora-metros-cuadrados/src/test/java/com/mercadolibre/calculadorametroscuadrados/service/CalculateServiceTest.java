package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @InjectMocks
    private CalculateService calculateService;

    @Test
    void calculateOkTest() {

        RoomDTO room1 = new RoomDTO();
        room1.setName("room 1");
        room1.setLength(10);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("room 2");
        room2.setLength(5);
        room2.setWidth(2);

        HouseDTO parameter = new HouseDTO();
        parameter.setName("house");
        parameter.setAddress("Av. Siempre Viva 123");
        parameter.setRooms(List.of(room1, room2));

        HouseResponseDTO expected = new HouseResponseDTO(parameter);
        expected.setSquareFeet(60);
        expected.setBiggest(room1);
        expected.setPrice(48000);

        HouseResponseDTO result = calculateService.calculate(parameter);

        Assertions.assertEquals(expected, result);


    }
}