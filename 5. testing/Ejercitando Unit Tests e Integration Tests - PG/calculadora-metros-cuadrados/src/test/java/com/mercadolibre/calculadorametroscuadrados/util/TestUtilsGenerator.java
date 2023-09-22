package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {

    public static HouseDTO generateEmptyHouseDTO() {
        HouseDTO houseParam = new HouseDTO();
        houseParam.setName("Home");
        houseParam.setAddress("Gaspar Campos 1400");
        return houseParam;
    }

    public static HouseDTO generateOneRoomHouseDTO() {
        HouseDTO emptyHouse = generateEmptyHouseDTO();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO bedRoom = new RoomDTO();
        bedRoom.setName("Bedroom");
        bedRoom.setLength(2);
        bedRoom.setWidth(2);
        roomDTOList.add(bedRoom);
        emptyHouse.setRooms(roomDTOList);

        return emptyHouse;
    }

    public static HouseDTO generateManyRoomsHouseDTO() {
        HouseDTO oneRoomHouse = generateOneRoomHouseDTO();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO kitchen = new RoomDTO();
        kitchen.setName("Kitchen");
        kitchen.setLength(3);
        kitchen.setWidth(3);
        roomDTOList.add(kitchen);

        RoomDTO livingRoom = new RoomDTO();
        livingRoom.setName("Living Room");
        livingRoom.setLength(2);
        livingRoom.setWidth(3);
        roomDTOList.add(livingRoom);

        RoomDTO bathRoom = new RoomDTO();
        bathRoom.setName("Bath Room");
        bathRoom.setLength(1);
        bathRoom.setWidth(1);
        roomDTOList.add(bathRoom);

        oneRoomHouse.addRooms(roomDTOList);

        return oneRoomHouse;
    }

    public static RoomDTO getBiggestRoom() {
        RoomDTO biggestRoom = new RoomDTO();
        biggestRoom.setName("Kitchen");
        biggestRoom.setLength(3);
        biggestRoom.setWidth(3);
        return biggestRoom;
    }

}
