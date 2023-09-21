package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl repository;

    @InjectMocks
    FindService service;

    @Test
    void find(){
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(new CharacterDTO("Luke Skywalker", "blond", "fair","blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        String query = "Luke";

        when(repository.findAllByNameContains(query)).thenReturn(characters);

        Assertions.assertEquals(service.find(query), characters);
    }

}
