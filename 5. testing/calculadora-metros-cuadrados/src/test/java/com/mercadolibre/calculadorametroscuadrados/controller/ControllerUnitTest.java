package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;


public class ControllerUnitTest {
    CalculateRestController controller = new CalculateRestController();

    @Test
    void calculateOk(){
        //ARRANGER
        HouseDTO parameter = new HouseDTO("Casa1","Siempreviva 1234", List.of(new RoomDTO("Habitacion",2,4),new RoomDTO("Habitacion Grande", 8,2)));
        HouseResponseDTO expectedReturn = new HouseResponseDTO(parameter);
        expectedReturn.setSquareFeet(24);
        expectedReturn.setPrice(19200);
        expectedReturn.setBiggest(new RoomDTO("Habitacion",2,4));
        //ACT
        HouseResponseDTO actual = controller.calculate(parameter);

        //ASSERTION
        Assertions.assertEquals(expectedReturn.getPrice(),actual.getPrice());
    }
}
