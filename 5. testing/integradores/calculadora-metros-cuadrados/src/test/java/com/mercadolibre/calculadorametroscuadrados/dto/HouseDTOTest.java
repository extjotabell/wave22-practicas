package com.mercadolibre.calculadorametroscuadrados.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HouseDTOTest {

    @Test
    void testCreateHouseDTO() {
        HouseDTO house = new HouseDTO();
        assertNotNull(house);
    }

    @Test
    void testSetName() {
        HouseDTO house = new HouseDTO();
        house.setName("Sample House");
        assertEquals("Sample House", house.getName());
    }

    @Test
    void testSetAddress() {
        HouseDTO house = new HouseDTO();
        house.setAddress("123 Main St");
        assertEquals("123 Main St", house.getAddress());
    }

    @Test
    void testSetRooms() {
        HouseDTO house = new HouseDTO();
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Living Room");
        rooms.add(room1);
        house.setRooms(rooms);

        assertEquals(1, house.getRooms().size());
        assertEquals("Living Room", house.getRooms().get(0).getName());
    }
}
