package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CalculateServiceTest {

    @Mock
    CalculateService repo;
    @InjectMocks
    CalculateService service;

    @Test
    void calculateTest(){
        HouseDTO houseDTO = new HouseDTO("Casa soñada", "macedonio fernandez", List.of(
                new RoomDTO("pieza", 4, 5), new RoomDTO("cocina", 6, 3)));

        RoomDTO roomDTO1 = new RoomDTO("pieza", 4, 5);
        RoomDTO roomDTO2 = new RoomDTO("cocina", 6, 3);
        List<RoomDTO> roomDTOList = new ArrayList<>(List.of(new RoomDTO[]{roomDTO1, roomDTO2}));
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO("Casa soñada", "macedonio fernandez",roomDTOList,38,30400,roomDTO1);
        Mockito.when(repo.calculateRoomSquareFeet(houseDTO,houseResponseDTO))
                .thenReturn()
    }

}
