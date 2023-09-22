package com.mercadolibre.starwars.unittest.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterRepositoryTest {
    CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains_Ok() {
        TestUtil.charactersFile();
        String query = "Darth";
        List<CharacterDTO> expectedCharacters = TestUtil.getAllCharactersDTO().stream().filter(characterDTO -> characterDTO.getName().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList());
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        Assertions.assertEquals(expectedCharacters, result);
    }
}
