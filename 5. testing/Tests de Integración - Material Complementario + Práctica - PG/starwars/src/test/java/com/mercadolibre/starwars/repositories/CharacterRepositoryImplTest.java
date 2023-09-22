package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CharacterRepositoryImplTest {

    @Autowired
    CharacterRepository characterRepository;

    @Test
    void findAllByNameContainsOkTest() {
        // ARRANGE
        String param = "Luke";
        // ACT
        List<CharacterDTO> response = characterRepository.findAllByNameContains(param);
        // ASSERT
        Assertions.assertTrue(response.get(0).getName().contains(param));
    }

    @Test
    void findAllByNameContainsEmptyTest() {
        // ARRANGE
        String param = "XXXXXXXXXXX";
        // ACT
        List<CharacterDTO> response = characterRepository.findAllByNameContains(param);
        // ASSERT
        Assertions.assertEquals(0, response.size());
    }

}
