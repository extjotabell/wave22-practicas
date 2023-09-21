package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepositoryMock; // Interfaz del repo

    @InjectMocks
    FindService findService;

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
        Mockito.when(characterRepositoryMock.findAllByNameContains(param)).thenReturn(expectedCharacters);

        // El de verdad
        List<CharacterDTO> obtained = findService.find(param);

        // ASSERT
        Assertions.assertEquals(expectedCharacters, obtained);
    }

    @Test
    void findEmptyTest() {
        // ARRANGE
        List<CharacterDTO> emptyList = new ArrayList<>();
        Mockito.when(characterRepositoryMock.findAllByNameContains("XXXXXXX")).thenReturn(emptyList);
        // ACT
        List<CharacterDTO> current = findService.find("XXXXXXX");
        // ASSERT
        Assertions.assertEquals(0, current.size());

    }
}
