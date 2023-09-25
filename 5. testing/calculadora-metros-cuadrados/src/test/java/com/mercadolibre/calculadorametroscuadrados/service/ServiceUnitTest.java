package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServiceUnitTest {
    static HouseDTO parameter;
    @BeforeAll
    static void init(){
        parameter = new HouseDTO("Casa1","Siempreviva 1234", List.of(new RoomDTO("Habitacion",2,4),new RoomDTO("Habitacion Grande", 8,2)));
    }
    CalculateService service = new CalculateService();

    @Test
    void calculatePriceOk(){
        //ARRANGE
        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setSquareFeet(8);
        expected.setPrice(19200);
        expected.setBiggest(new RoomDTO("Habitacion",2,4));
        //ACT
        HouseResponseDTO actual = service.calculate(parameter);
        //ASSERTION
        Assertions.assertEquals(expected.getPrice(),actual.getPrice());
    }

    @Test
    void biggestRoomOk(){
        //ARRANGE
        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setSquareFeet(8);
        expected.setPrice(19200);
        expected.setBiggest(new RoomDTO("Habitacion Grande",8,2));
        //ACT
        HouseResponseDTO actual = service.calculate(parameter);
        //ASSERTION
        Assertions.assertEquals(expected.getBiggest().getName(),actual.getBiggest().getName());
    }

    @Test
    void squareFeetOk(){
        //ARRANGE
        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setSquareFeet(24);
        expected.setPrice(19200);
        expected.setBiggest(new RoomDTO("Habitacion Grande",8,2));
        HouseResponseDTO expected2 = new HouseResponseDTO();
        expected2.setSquareFeet(24);
        expected2.setPrice(19200);
        expected2.setBiggest(new RoomDTO("Habitacion",2,4));
        //ACT
        HouseResponseDTO actual = service.calculate(parameter);
        //ASSERTION
        Assertions.assertEquals(expected.getSquareFeet(),actual.getSquareFeet());
    }

}
