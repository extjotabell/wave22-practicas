package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @InjectMocks
    FindService findService;
    @Mock
    CharacterRepository characterRepository;

    private final List<CharacterDTO> database = List.of(
            new CharacterDTO("Luke Skywalker","blond", "fair", "blue",
                    "19BBY","male","Tatooine", "Human", 172, 77),
            new CharacterDTO("C-3PO","NA","gold","yellow",
                    "112BBY","NA","Tatooine","Droid",167, 75));
    @Test
    void findTestOk()
    {
        //ARRANGE
        List<CharacterDTO> expected = database.stream().filter(c -> c.getName().equals("Luke")).collect(Collectors.toList());
        //ACT
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(expected);
        List<CharacterDTO> characters = findService.find("Luke");

        //Assert
        assertEquals(expected, characters);
    }

    @Test
    void findTestEmpty()
    {
        //ARRANGE
        List<CharacterDTO> expected = database.stream().filter(c -> c.getName().equals("Prueba")).collect(Collectors.toList());
        //ACT
        when(characterRepository.findAllByNameContains("Prueba")).thenReturn(expected);
        List<CharacterDTO> characters = findService.find("Prueba");

        //Assert
        assertEquals(expected,characters);
    }

}
