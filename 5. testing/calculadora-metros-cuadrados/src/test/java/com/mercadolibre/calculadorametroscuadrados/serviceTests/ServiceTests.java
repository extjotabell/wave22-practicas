package com.mercadolibre.calculadorametroscuadrados.serviceTests;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTests {

    @Autowired
    CalculateService service;

    @Test
    void calculateOkTest(){
        // Arrenge
        RoomDTO room1 = new RoomDTO();
        room1.setName("Lavadero");
        room1.setLength(5);
        room1.setWidth(10);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Sala de estar");
        room2.setLength(50);
        room2.setWidth(10);

        RoomDTO room3 = new RoomDTO();
        room2.setName("Dormitorio");
        room2.setLength(20);
        room2.setWidth(15);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Hogar");
        houseDTO.setAddress("Reconquista 266");
        houseDTO.setRooms(List.of( room1, room2, room3));

        HouseResponseDTO expectedResponseDTO = new HouseResponseDTO(houseDTO);
        expectedResponseDTO.setBiggest(room2);
        expectedResponseDTO.setSquareFeet(350);
        expectedResponseDTO.setPrice(280000);

        //Act
        HouseResponseDTO response = service.calculate(houseDTO);

        //Assert
        //Assertions.assertEquals(expectedResponseDTO, response); // Comparar dos objetos iguales con equals no me funciona.
        Assertions.assertEquals(expectedResponseDTO.getSquareFeet(), response.getSquareFeet());
        Assertions.assertEquals(expectedResponseDTO.getPrice(), response.getPrice());
        Assertions.assertEquals(expectedResponseDTO.getBiggest(), response.getBiggest());
    }

}
