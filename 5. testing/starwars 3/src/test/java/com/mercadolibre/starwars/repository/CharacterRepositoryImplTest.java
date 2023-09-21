package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryImplTest {

    @Autowired
    CharacterRepository characterRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.characterRepository = new CharacterRepositoryImpl();
    }


    @Test
    void findNameLukeTest() {
        String query = "Luke";

        List<CharacterDTO> listCharacters = characterRepository.findAllByNameContains(query);

        assertNotNull(listCharacters);
        assertEquals(1, listCharacters.size());
    }

    @Test
    void findNameDarthTest() {
        String query = "Darth";

        List<CharacterDTO> listCharacters = characterRepository.findAllByNameContains(query);

        assertNotNull(listCharacters);
        assertEquals(2, listCharacters.size());
    }



    @Test
    void testFindAllByNameContains_NoMatchingName() {
        String query = "NonExistentName";

        assertNotNull(characterRepository.findAllByNameContains(query));
        assertTrue(characterRepository.findAllByNameContains(query).isEmpty());
    }
}
