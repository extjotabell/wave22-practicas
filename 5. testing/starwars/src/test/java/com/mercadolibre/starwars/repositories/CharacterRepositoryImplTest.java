package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllByNameContains() {
        List<CharacterDTO> listCharacters = new ArrayList<>();

        listCharacters = characterRepository.findAllByNameContains("luke");

        assertEquals(1,listCharacters.size());


    }
}