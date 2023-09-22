package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class CharacterRepositoryImplTest {

    @Autowired
    CharacterRepository repository;

    @Test
    void findAllByNameContainsOkTest(){
        // ARRANGE
        String param = "Luke";

        // ACT
        List<CharacterDTO> response = repository.findAllByNameContains(param);

        // ASSERT
        assertTrue(response.get(0).getName().contains(param));
    }

    @Test
    void findAllByNameContainsNotOk() {
        // ARRANGE
        String param = "XXX";

        // ACT
        List<CharacterDTO> responseEmpty = repository.findAllByNameContains(param);


        // ASSERT
        assertEquals(0,responseEmpty.size());

    }
}
