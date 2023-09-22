package com.mercadolibre.calculadorametroscuadrados.unitTesting.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CalculateServiceTests {

    @Autowired
    CalculateService service;

    @Test
    void calculatePriceOkTest(){
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(new RoomDTO("Env 1", 20, 20));
        HouseDTO house = new HouseDTO("House", "AD7", rooms);
        int expectedPrice = 20 * 20 * 800;

        Assertions.assertEquals(expectedPrice, service.calculate(house).getPrice());
    }

    @Test
    void verifyBiggestRoomTestOk(){
        RoomDTO room1 = new RoomDTO("Kitchen", 10, 10);
        RoomDTO room2 = new RoomDTO("Living", 50, 50);
        RoomDTO room3 = new RoomDTO("Bathroom", 5, 5);
        List<RoomDTO> rooms = List.of(room1, room2, room3);
        HouseDTO house = new HouseDTO("House", "AD7", rooms);

        Assertions.assertEquals(room2, service.calculate(house).getBiggest());

    }

    @Test
    void verifySquareMetersPerRoomTestOk(){
        RoomDTO room1 = new RoomDTO("Kitchen", 10, 10);
        RoomDTO room2 = new RoomDTO("Living", 50, 50);
        RoomDTO room3 = new RoomDTO("Bathroom", 5, 5);
        List<RoomDTO> rooms = List.of(room1, room2, room3);
        HouseDTO house = new HouseDTO("House", "AD7", rooms);

        HouseResponseDTO result = service.calculate(house);

        Assertions.assertEquals(100, result.getRooms().get(0).getSquareFeet());
        Assertions.assertEquals(2500, result.getRooms().get(1).getSquareFeet());
        Assertions.assertEquals(25, result.getRooms().get(2).getSquareFeet());
    }
}
