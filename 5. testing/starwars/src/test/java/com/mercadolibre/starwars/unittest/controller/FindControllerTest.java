package com.mercadolibre.starwars.unittest.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void find() {
        // ARRANGE
        String query = "Luke";
        List<CharacterDTO> serviceReturn = new ArrayList<>(
                List.of(
                        new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
                )
        );

        List<CharacterDTO> expectedResult = new ArrayList<>(
                List.of(
                        new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
                )
        );
        when(findService.find(query)).thenReturn(serviceReturn);

        // ACT
        List<CharacterDTO> result = findController.find(query);

        // ASSERT
        verify(findService, times(1)).find(query);
        assertEquals(expectedResult, result);
    }
}
