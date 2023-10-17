package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.utils.ObjectFactoryHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CharacterRepositoryTest {
    @InjectMocks
    CharacterRepositoryImpl characterRepository;

    @Mock
    ObjectMapper objectMapper;

    List<CharacterDTO> database;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        database = ObjectFactoryHelper.createSampleCharacterList();
    }

    @Test
    @DisplayName("1- FindAllByNameContains OK")
    void findAll_ok(){
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");
        Assertions.assertNotNull(result);
    }

}
