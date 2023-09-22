package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class CalculadoraMetrosCuadradosServiceUnitaryTests {

    @Autowired
    CalculateService calculateService;

    @Test
    public void CalculatePriceOkTest() {
        // ARRANGE
        HouseDTO houseParam = TestUtilsGenerator.generateOneRoomHouseDTO();

        int priceExpected = 3200;

        // ACT
        HouseResponseDTO houseResponseObtained = calculateService.calculate(houseParam);

        // ASSERT
        Assertions.assertEquals(priceExpected, houseResponseObtained.getPrice());
    }


    @Test
    public void CalculateBiggestRoomOkTest() {
        // ARRANGE
        HouseDTO houseParam = TestUtilsGenerator.generateManyRoomsHouseDTO();

        // ACT
        HouseResponseDTO houseResponseObtained = calculateService.calculate(houseParam);

        // ASSERT
        Assertions.assertEquals(TestUtilsGenerator.getBiggestRoom(), houseResponseObtained.getBiggest());
    }

    @Test
    public void CalculateSquareFeetPerRoomOkTest() {
        // ARRANGE
        // Generated house with many rooms to use
        HouseDTO houseParam = TestUtilsGenerator.generateManyRoomsHouseDTO();
        // Get the rooms
        List<RoomDTO> roomDTOList = houseParam.getRooms();
        // Define expected square feet for each room
        int bedroomExpectedSquareFeet = 2 * 2;
        int kitchenExpectedSquareFeet = 3 * 3;
        int livingExpectedSquareFeet = 2 * 3;
        int bathroomExpectedSquareFeet = 1   ;


        // ACT
        HouseResponseDTO houseResponseObtained = calculateService.calculate(houseParam);

        // ASSERT
        Assertions.assertEquals(bedroomExpectedSquareFeet, houseResponseObtained.getRooms().get(0).getSquareFeet());
        Assertions.assertEquals(kitchenExpectedSquareFeet, houseResponseObtained.getRooms().get(1).getSquareFeet());
        Assertions.assertEquals(livingExpectedSquareFeet, houseResponseObtained.getRooms().get(2).getSquareFeet());
        Assertions.assertEquals(bathroomExpectedSquareFeet, houseResponseObtained.getRooms().get(3).getSquareFeet());
    }

}
