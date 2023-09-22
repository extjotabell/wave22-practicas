package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    public void calculoValor(){
        //Arrange
        HouseResponseDTO expected = new HouseResponseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setName("cuarto 1");
        room1.setWidth(2);
        room1.setLength(2);
        List<RoomDTO> rooms=new ArrayList<>();
        rooms.add(room1);

        HouseDTO param = new HouseDTO();
        param.setName("Casa");
        param.setAddress("hola 123");
        param.setRooms(rooms);

        expected.setRooms(rooms);
        expected.setPrice(3200);


        //Act

        HouseResponseDTO obtained = calculateService.calculate(param);

        //Assert

        assertEquals(expected.getPrice(),obtained.getPrice());

    }

    @Test
    public void mayorRoom(){
        //Arrange
        HouseResponseDTO expected = new HouseResponseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setName("cuarto 1");
        room1.setWidth(2);
        room1.setLength(2);

        RoomDTO room2 = new RoomDTO();
        room2.setName("cuarto 2");
        room2.setLength(3);
        room2.setWidth(3);

        List<RoomDTO> rooms=new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        HouseDTO param = new HouseDTO();
        param.setName("Casa");
        param.setAddress("hola 123");
        param.setRooms(rooms);

        expected.setBiggest(room2);
        expected.setRooms(rooms);

        //Act

        HouseResponseDTO obtained = calculateService.calculate(param);

        //Assert

        assertEquals(expected.getBiggest(),obtained.getBiggest());

    }

    @Test
    public void metrosCuadradostest(){
        //Arrange
        HouseResponseDTO expected = new HouseResponseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setName("cuarto 1");
        room1.setWidth(2);
        room1.setLength(2);
        List<RoomDTO> rooms=new ArrayList<>();
        rooms.add(room1);

        HouseDTO param = new HouseDTO();
        param.setName("Casa");
        param.setAddress("hola 123");
        param.setRooms(rooms);


        expected.setSquareFeet(4);

        //Act

        HouseResponseDTO obtained = calculateService.calculate(param);

        //Assert

        assertEquals(expected.getSquareFeet(),obtained.getSquareFeet());

    }


}
