package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllertTest {
    @Mock
    private FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void findTest() {
        List<CharacterDTO> characterDTOList = List.of(
                new CharacterDTO(
                        "Luke Skywalker",
                        "Tatooine",
                        "Human",
                        "blond",
                        "fair",
                        "blue",
                        "19BBY",
                        "male",
                        172,
                        77
                )
        );
        String query = "luke";

        when(findService.find(query)).thenReturn(characterDTOList);

        List<CharacterDTO> listResult = findController.find(query);
        assertEquals(characterDTOList, listResult);
    }
}
