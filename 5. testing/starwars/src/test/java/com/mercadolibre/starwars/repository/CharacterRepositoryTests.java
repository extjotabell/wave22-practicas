package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CharacterRepositoryTests {

    @Autowired
    private CharacterRepository characterRepository;

    private static ObjectMapper mapper;

    @BeforeAll
    static void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void findAllByNameContainsOneCharacterOk() throws JsonProcessingException {

        //Arrange
        String jsonString = "{" +
                "\"name\": \"Luke Skywalker\"," +
                "\"hair_color\": \"blond\"," +
                "\"skin_color\": \"fair\"," +
                "\"eye_color\": \"blue\"," +
                "\"birth_year\": \"19BBY\"," +
                "\"gender\": \"male\"," +
                "\"homeworld\": \"Tatooine\"," +
                "\"species\": \"Human\"," +
                "\"height\": 172," +
                "\"mass\": 77" +
                "}";
        CharacterDTO lukeExpected = mapper.readValue(jsonString, CharacterDTO.class);
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(lukeExpected);

        //Act
        List<CharacterDTO> actual = characterRepository.findAllByNameContains("Luke");

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void findAllByNameContainsMoreThanOneCharacterOk() throws JsonProcessingException {

        //Arrange
        String jsonString1 = "{\"name\": \"Anakin Skywalker\",\"hair_color\": \"blond\",\"skin_color\": \"fair\",\"eye_color\": \"blue\",\"birth_year\": \"41.9BBY\",\"gender\": \"male\",\"homeworld\": \"Tatooine\",\"species\": \"Human\",\"height\": 188,\"mass\": 84}";
        String jsonString2 = "{\"name\": \"Luke Skywalker\",\"hair_color\": \"blond\",\"skin_color\": \"fair\",\"eye_color\": \"blue\",\"birth_year\": \"19BBY\",\"gender\": \"male\",\"homeworld\": \"Tatooine\",\"species\": \"Human\",\"height\": 172,\"mass\": 77}";
        String jsonString3 = "{\"name\": \"Shmi Skywalker\",\"hair_color\": \"black\",\"skin_color\": \"fair\",\"eye_color\": \"brown\",\"birth_year\": \"72BBY\",\"gender\": \"female\",\"homeworld\": \"Tatooine\",\"species\": \"Human\",\"height\": 163,\"mass\": null}";
        CharacterDTO anakinExpected = mapper.readValue(jsonString1, CharacterDTO.class);
        CharacterDTO lukeExpected = mapper.readValue(jsonString2, CharacterDTO.class);
        CharacterDTO shmiExpected = mapper.readValue(jsonString3, CharacterDTO.class);
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(lukeExpected);
        expected.add(anakinExpected);
        expected.add(shmiExpected);

        //Act
        List<CharacterDTO> actual = characterRepository.findAllByNameContains("Skywalker");

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void findAllByNameContainsEmpty() {
        //Arrange
        List<CharacterDTO> expected = new ArrayList<>();

        //Act
        List<CharacterDTO> actual = characterRepository.findAllByNameContains("rodro");

        //Assert
        assertEquals(expected, actual);
    }
}
