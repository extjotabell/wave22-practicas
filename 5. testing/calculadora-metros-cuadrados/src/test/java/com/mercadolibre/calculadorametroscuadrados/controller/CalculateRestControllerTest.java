package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculateRestControllerTest {
    @Autowired
    CalculateRestController calculateRestController;

    @Test
    void calculatePrice() {
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        RoomDTO roomDTO = new RoomDTO();

        houseDTO.setAddress("address1");
        houseDTO.setName("name1");
        houseDTO.setRooms(List.of(roomDTO));

        roomDTO.setName("Room1");
        roomDTO.setLength(10);
        roomDTO.setWidth(10);

        int expectedPrice = 100 * 800;

        //Act
        HouseResponseDTO resultHouse = this.calculateRestController.calculate(houseDTO);
        int resultPrice = resultHouse.getPrice();

        //Assert
        assertEquals(expectedPrice, resultPrice);
    }

    @Test
    void calculateBiggestRoom(){
        //Arrange
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

        //Act
        HouseResponseDTO result = this.calculateRestController.calculate(houseDTO);
        RoomDTO resultBiggestRoom = result.getBiggest();

        //Assert
        assertEquals(roomBiggest, resultBiggestRoom);
    }

    @Test
    void calculateSquareFeet(){
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

        int expectedSquareFeet = 125;

        //Act
        HouseResponseDTO result = this.calculateRestController.calculate(houseDTO);
        int resultSquareFeet = result.getSquareFeet();

        //Assert
        assertEquals(expectedSquareFeet, resultSquareFeet);
    }
}