package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

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

        List<CharacterDTO> listResult = findService.find(query);
        assertEquals(characterDTOList, listResult);

    }

    @Test
    public void findDarthTest() {
        List<CharacterDTO> characterDTOList = List.of(
                new CharacterDTO(
                        "Darth Vader",
                        "Tatooine",
                        "Human",
                        "none",
                        "white",
                        "yellow",
                        "41.9BBY",
                        "male",
                        202,
                        136
                ),
                new CharacterDTO(
                        "Darth Maul",
                        "Dathomir",
                        "Zabrak",
                        "none",
                        "red",
                        "yellow",
                        "54BBY",
                        "male",
                        175,
                        80
                )
        );
        String query = "darth";

        when(findService.find(query)).thenReturn(characterDTOList);

        List<CharacterDTO> listResult = findService.find(query);
        assertEquals(characterDTOList, listResult);
        assertEquals(2, listResult.size());

    }

    @Test
    public void findNonExistTest() {
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        String query = "NonExist";

        when(findService.find(query)).thenReturn(characterDTOList);

        List<CharacterDTO> listResult = findService.find(query);
        assertEquals(characterDTOList, listResult);
        assertEquals(0, listResult.size());
    }

}
