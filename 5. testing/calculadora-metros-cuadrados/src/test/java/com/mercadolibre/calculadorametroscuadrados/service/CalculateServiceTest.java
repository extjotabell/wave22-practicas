package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculateServiceTest {

    @Autowired
    CalculateService calculateService;


    @Test
    void calculate() {
        HouseDTO houseDTO = TestUtils.generateHouseDTO();

        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        assertEquals(100,houseResponseDTO.getSquareFeet());

    }
}