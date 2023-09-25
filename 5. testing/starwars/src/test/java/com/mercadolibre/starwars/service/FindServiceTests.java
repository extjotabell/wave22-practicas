package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {

    @Mock
    private CharacterRepositoryImpl characterRepository;

    @InjectMocks
    private FindService findService;

    private static ObjectMapper mapper;

    @BeforeAll
    static void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void findTestOk() throws JsonProcessingException {
        //Arrange
        String jsonString = "{\"name\": \"Anakin Skywalker\",\"hair_color\": \"blond\",\"skin_color\": \"fair\",\"eye_color\": \"blue\",\"birth_year\": \"41.9BBY\",\"gender\": \"male\",\"homeworld\": \"Tatooine\",\"species\": \"Human\",\"height\": 188,\"mass\": 84}";
        CharacterDTO anakin = mapper.readValue(jsonString, CharacterDTO.class);
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(anakin);

        //Act
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(expected);
        List<CharacterDTO> actual = findService.find("Anakin");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void findTestEmpty() throws JsonProcessingException {
        //Arrange
        List<CharacterDTO> expected = new ArrayList<>();

        //Act
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(List.of());
        List<CharacterDTO> actual = findService.find("Anakin");

        //Assert
        assertEquals(expected, actual);
    }

}
