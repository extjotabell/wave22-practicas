package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class TestUtilsGenerator {

    public static List<RoomDTO> generateRooms () {
        List<RoomDTO> listRoom = List.of(
                new RoomDTO("Sala de estar", 5, 6),
                new RoomDTO("Dormitorio principal", 4, 5),
                new RoomDTO("Cocina", 6, 7)
        );
        return listRoom;
    }

    public static HouseDTO generateHouseDto () {
        List<RoomDTO> listRoom = generateRooms();
        return new HouseDTO("Mi Casa", "123 Calle Principal", listRoom);
    }




}
