package com.mercadolibre.calculadorametroscuadrados.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {
    @InjectMocks
    private CalculateService calculateService;


    @Test
    void calculatePriceTets(){
        Integer expectedPrice = 73600;
        Integer expectedSquareFeet = 92;
        HouseDTO houseTest = TestUtilsGenerator.generateHouseDto();

        HouseResponseDTO obtain = calculateService.calculate(houseTest);

        Assertions.assertEquals(expectedPrice,obtain.getPrice());
        Assertions.assertEquals(expectedSquareFeet,obtain.getSquareFeet());

    }

}
