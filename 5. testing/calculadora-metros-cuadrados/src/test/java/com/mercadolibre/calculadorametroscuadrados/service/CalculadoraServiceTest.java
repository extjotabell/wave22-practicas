package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtilGenerator.getHouse2Room;

@SpringBootTest
public class CalculadoraServiceTest {

    @Autowired
    CalculateService calculateService;

    @Test
    void calculatePriceTets(){
        //Arrange
        Integer expected = 128000;
        HouseDTO param = getHouse2Room();

        //Act
        HouseResponseDTO obtain = calculateService.calculate(param);

        //Assert
        Assertions.assertEquals(expected,obtain.getPrice());
    }

    @Test
    void calculateBiggestRoomTets(){
        //Arrange
        RoomDTO expected = new RoomDTO("Habitacion de Lisa",10,10);
        HouseDTO param = getHouse2Room();

        //Act
        HouseResponseDTO obtain = calculateService.calculate(param);

        //Assert
        Assertions.assertEquals(expected,obtain.getBiggest());
    }

    @Test
    void calculateSquareFeetTets(){
        //Arrange
        Integer expected = 160;
        HouseDTO param = getHouse2Room();

        //Act
        HouseResponseDTO obtain = calculateService.calculate(param);

        //Assert
        Assertions.assertEquals(expected,obtain.getSquareFeet());
    }
}
