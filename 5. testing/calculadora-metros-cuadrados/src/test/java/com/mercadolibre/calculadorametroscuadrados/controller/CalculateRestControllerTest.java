package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    void calculate() {

        RoomDTO room1 = new RoomDTO();
        room1.setName("room 1");
        room1.setLength(10);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("room 2");
        room2.setLength(5);
        room2.setWidth(2);

        HouseDTO body = new HouseDTO();
        body.setName("house");
        body.setAddress("Av. Siempre Viva 123");
        body.setRooms(List.of(room1, room2));

        HouseResponseDTO expected = new HouseResponseDTO(body);
        expected.setSquareFeet(60);
        expected.setBiggest(room1);
        expected.setPrice(48000);

        try (MockedConstruction<CalculateService> mocked = Mockito.mockConstruction(CalculateService.class,
                (mock, context) -> {
                    when(mock.calculate(any(HouseDTO.class))).thenReturn(expected);
                })) {
            HouseResponseDTO result = calculateRestController.calculate(body);
            verify(mocked.constructed().get(0), atLeastOnce()).calculate(any(HouseDTO.class));
            Assertions.assertEquals(expected.getPrice(), result.getPrice());
        }
    }
}