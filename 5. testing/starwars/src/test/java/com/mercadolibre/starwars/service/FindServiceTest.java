package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService characterService;

    @Test
    void findTestOK(){
        CharacterDTO darthVader = new CharacterDTO("Darth Vader", "none", "white", "yellow",
                "41.9BBY","male","Tatooine","Human",202,136);

        CharacterDTO darthMaul = new CharacterDTO("Darth Maul", "none", "white", "yellow",
                "41.9BBY","male","Tatooine","Human",202,136);

        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(darthMaul);
        characters.add(darthVader);

        Mockito.when(characterRepository.findAllByNameContains("")).thenReturn(characters);

        Assertions.assertEquals(characters, characterService.find(""));
    }

}
