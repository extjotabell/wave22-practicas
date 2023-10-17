package com.mercadolibre.calculadorametroscuadrados.dto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RoomDTOTest {

    @Test
    void testCreateRoomDTO() {
        RoomDTO roomDTO = new RoomDTO();
        assertNotNull(roomDTO);
    }

    @Test
    void testSetName() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Living Room");
        assertEquals("Living Room", roomDTO.getName());
    }

    @Test
    void testSetWidth() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setWidth(5);
        assertEquals(5, roomDTO.getWidth());
    }

    @Test
    void testSetLength() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setLength(6);
        assertEquals(6, roomDTO.getLength());
    }

    @Test
    void testGetSquareFeet() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setWidth(5);
        roomDTO.setLength(6);
        assertEquals(30, roomDTO.getSquareFeet());
    }

    @Test
    void testGetSquareFeetWithNullDimensions() {
        RoomDTO roomDTO = new RoomDTO();
        assertNull(roomDTO.getWidth());
        assertNull(roomDTO.getLength());
        assertEquals(0, roomDTO.getSquareFeet());
    }
}