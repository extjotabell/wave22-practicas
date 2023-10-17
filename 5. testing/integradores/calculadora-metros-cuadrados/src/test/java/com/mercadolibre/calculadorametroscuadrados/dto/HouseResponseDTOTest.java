package com.mercadolibre.calculadorametroscuadrados.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class HouseResponseDTOTest {

    @Test
    void testCreateHouseResponseDTO() {
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        assertNotNull(houseResponseDTO);
    }

    @Test
    void testCreateHouseResponseDTOFromHouseDTO() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Sample House");
        houseDTO.setAddress("123 Main St");

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Living Room");
        rooms.add(room1);

        houseDTO.setRooms(rooms);

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
        assertEquals("Sample House", houseResponseDTO.getName());
        assertEquals("123 Main St", houseResponseDTO.getAddress());
        assertEquals(1, houseResponseDTO.getRooms().size());
        assertEquals("Living Room", houseResponseDTO.getRooms().get(0).getName());
    }

    @Test
    void testSetSquareFeet() {
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setSquareFeet(2000);
        assertEquals(2000, houseResponseDTO.getSquareFeet());
    }

    @Test
    void testSetPrice() {
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setPrice(100000);
        assertEquals(100000, houseResponseDTO.getPrice());
    }

    @Test
    void testSetBiggest() {
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        RoomDTO biggestRoom = new RoomDTO();
        biggestRoom.setName("Master Bedroom");
        houseResponseDTO.setBiggest(biggestRoom);
        assertEquals("Master Bedroom", houseResponseDTO.getBiggest().getName());
    }
}