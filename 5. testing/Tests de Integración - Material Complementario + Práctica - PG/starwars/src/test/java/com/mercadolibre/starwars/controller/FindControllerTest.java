package com.mercadolibre.starwars.controller;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findServiceMock; // Interfaz del service

    @InjectMocks
    FindController findController;

    @Test
    void findOkTest() {
        // ARRANGE
        final String param = "Luke";
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        expectedCharacters.add(
                new CharacterDTO(
                        "Luke Skywalker",
                        172,
                        77,
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        "Tatooine",
                        "Human"
                )
        );

        // ACT

        // El simulado
        Mockito.when(findServiceMock.find(param)).thenReturn(expectedCharacters);

        // El de verdad
        List<CharacterDTO> obtained = findController.find(param);

        // ASSERT
        Assertions.assertEquals(expectedCharacters, obtained);
    }

    @Test
    void findEmptyTest() {
        // ARRANGE
        List<CharacterDTO> emptyList = new ArrayList<>();
        final String param ="XXXXXXX";
        Mockito.when(findServiceMock.find(param)).thenReturn(emptyList);
        // ACT
        List<CharacterDTO> current = findServiceMock.find(param);
        // ASSERT
        Assertions.assertEquals(0, current.size());

    }



}
