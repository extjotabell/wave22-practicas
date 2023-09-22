package com.mercadolibre.calculadorametroscuadrados.controller;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtilGenerator.getHouse2Room;
import static com.mercadolibre.calculadorametroscuadrados.utils.TestUtilGenerator.getHouseResponse;

@ExtendWith(MockitoExtension.class)
public class CalculateREstControllerUnitTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculateOkTest(){
        //Arrange
        HouseResponseDTO expected = getHouseResponse();
        HouseDTO param = getHouse2Room();
        Mockito.when(calculateService.calculate(param)).thenReturn(expected);

        //Act
        HouseResponseDTO obtain = calculateRestController.calculate(param);

        //Assert
        Assertions.assertEquals(expected, obtain);
    }

}
