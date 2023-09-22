package com.mercadolibre.starwars.unittest.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
public class FindServiceTest {
    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findCharactersByName_Ok() {
        // ARRANGE
        String query = "Luke";
        List<CharacterDTO> repoReturn = new ArrayList<>(
                List.of(
                        new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
                )
        );

        List<CharacterDTO> expectedResult = new ArrayList<>(
                List.of(
                        new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
                )
        );
        when(characterRepository.findAllByNameContains(query)).thenReturn(repoReturn);

        // ACT
        List<CharacterDTO> result = findService.find(query);

        // ASSERT
        verify(characterRepository, times(1)).findAllByNameContains(query);
        assertEquals(expectedResult, result);
    }




}
