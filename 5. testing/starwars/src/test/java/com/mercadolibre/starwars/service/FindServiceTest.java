package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find(){
        //Arrange
        String query = "Luke Skywalker";
        CharacterDTO lukeSkywalker = new CharacterDTO("Luke Skywalker","blond", "fair","blue","19BBY", "male","Tatooine", "Human", 172, 77);
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of(lukeSkywalker));
        //Act
        List<CharacterDTO> characterDTOList = findService.find(query);
        //Assert
        Assertions.assertEquals(lukeSkywalker,characterDTOList.get(0));
    }

    @Test
    void findNone(){
        //Arrange
        String query = "Gaspar";
        int expectedSize = 0;
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of());
        //Act
        List<CharacterDTO> characterDTOList = findService.find(query);
        //Assert
        Assertions.assertEquals(expectedSize,characterDTOList.size());
    }
}
