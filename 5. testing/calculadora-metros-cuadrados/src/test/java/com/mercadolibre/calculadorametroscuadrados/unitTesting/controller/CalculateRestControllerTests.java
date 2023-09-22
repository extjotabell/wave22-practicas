package com.mercadolibre.calculadorametroscuadrados.unitTesting.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTests {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    void calculateTestOk(){
        RoomDTO room1 = new RoomDTO("Kitchen", 10, 10);
        RoomDTO room2 = new RoomDTO("Living", 50, 50);
        RoomDTO room3 = new RoomDTO("Bathroom", 5, 5);
        List<RoomDTO> rooms = List.of(room1, room2, room3);
        HouseDTO house = new HouseDTO("House", "AD7", rooms);
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(house);

        Assertions.assertEquals(houseResponseDTO, controller.calculate(house));
    }
}
