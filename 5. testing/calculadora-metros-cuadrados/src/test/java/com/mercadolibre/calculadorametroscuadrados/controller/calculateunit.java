package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class calculateunit {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    void calculateTest() {
        HouseDTO houseDTO = new HouseDTO("Casa soñada", "macedonio fernandez", List.of(
                new RoomDTO("pieza", 4, 5), new RoomDTO("cocina", 6, 3)));
        RoomDTO roomDTO1 = new RoomDTO("pieza", 4, 5);
        RoomDTO roomDTO2 = new RoomDTO("cocina", 6, 3);
        List<RoomDTO> roomDTOList = new ArrayList<>(List.of(new RoomDTO[]{roomDTO1, roomDTO2}));
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO("Casa soñada", "macedonio fernandez",roomDTOList,38,30400,roomDTO1);

        Mockito.when(service.calculate(any())).thenReturn(houseResponseDTO);
        HouseResponseDTO houseResponseresutl = controller.calculate(houseDTO);
        assertEquals(houseResponseDTO,houseResponseresutl);
    }
}



