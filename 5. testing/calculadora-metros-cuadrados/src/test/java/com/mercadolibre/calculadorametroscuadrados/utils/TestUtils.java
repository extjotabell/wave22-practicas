package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static HouseDTO generateHouseDTO(){

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("hab1");
        roomDTO.setLength(10);
        roomDTO.setWidth(10);

        List<RoomDTO> listRooms = new ArrayList<>();
        listRooms.add(roomDTO);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("casa1");
        houseDTO.setAddress("calle1");
        houseDTO.setRooms(listRooms);

        return houseDTO;

    }


}
