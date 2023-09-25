package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {
    @InjectMocks
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContainsTestOk() throws Exception
    {
        //ARRANGE
        List<CharacterDTO> characters = List.of(
                new CharacterDTO("Luke Skywalker","blond", "fair", "blue",
            "19BBY","male","Tatooine", "Human", 172, 77),
                new CharacterDTO("C-3PO","NA","gold","yellow",
                        "112BBY","NA","Tatooine","Droid",167, 75)
        );
        //ACT

        //ASSERT
    }
}
