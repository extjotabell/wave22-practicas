package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CharacterRepositoryImplTest {
    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContainsTestOk()
    {
        //ARRANGE
        String query = "Luke";

        //ACT
        List<CharacterDTO> characters = characterRepository.findAllByNameContains("Luke");

        //ASSERT
        assertTrue(characters.stream().allMatch(c -> c.getName().contains(query)));
    }

    @Test
    void findAllByNameContainsTestEmpty()
    {
        //ARRANGE
        String query = "Prueba";

        //ACT
        List<CharacterDTO> characters = characterRepository.findAllByNameContains(query);
        //ASSERT
        assertEquals(0, characters.size());
    }
}
