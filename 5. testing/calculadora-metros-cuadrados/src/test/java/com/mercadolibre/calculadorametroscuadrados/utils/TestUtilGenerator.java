package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;


public class TestUtilGenerator {
    public static HouseDTO getHouse2Room(){
        HouseDTO house = new HouseDTO();
        house.setName("Manshion");
        house.setAddress("Calle Falsa 123");

        RoomDTO room = new RoomDTO();
        room.setName("Habitacion de Bart");
        room.setLength(10);
        room.setWidth(6);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion de Lisa");
        room2.setLength(10);
        room2.setWidth(10);

        List<RoomDTO> habitaciones = new ArrayList<>();
        habitaciones.add(room);
        habitaciones.add(room2);

        house.setRooms(habitaciones);

        return house;
    }

    public static HouseDTO getHouse0Room(){
        HouseDTO house = new HouseDTO();
        house.setName("Manshion");
        house.setAddress("Calle Falsa 123");
        List<RoomDTO> rooms = new ArrayList<>();
        house.setRooms(rooms);
        return house;
    }

    public static HouseResponseDTO getHouseResponse(){
        HouseResponseDTO house = new HouseResponseDTO();
        RoomDTO room = new RoomDTO("Habitacion de Lisa",10,10);

        house.setBiggest(room);
        house.setPrice(10000);
        house.setSquareFeet(160);

        return house;
    }
}
