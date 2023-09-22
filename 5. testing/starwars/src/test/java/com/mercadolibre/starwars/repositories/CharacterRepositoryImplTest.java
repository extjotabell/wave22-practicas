package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    private final CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains() {

        List<CharacterDTO> result = characterRepository.findAllByNameContains("LuKe");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Luke Skywalker", result.get(0).getName());
    }
}