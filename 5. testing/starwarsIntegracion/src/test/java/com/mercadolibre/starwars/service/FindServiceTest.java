package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.CharacterRepositoryImpl;
import com.mercadolibre.starwars.dto.CharacterDTO;
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
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findOkTest(){
        //Arrange
        String param = "Luke";
        List<CharacterDTO> devolution = new ArrayList<>();
        List<CharacterDTO> devolutionMock = new ArrayList<>();
        devolution.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));
        devolutionMock.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));

        //Act
        Mockito.when(characterRepository.findAllByNameContains(param)).thenReturn(devolutionMock);
        List<CharacterDTO> obtain = findService.find(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);

    }

    @Test
    void findEmptyTest(){
        //Arrange
        String param = "Lukasdasdasdasde";
        List<CharacterDTO> devolution = new ArrayList<>();
        List<CharacterDTO> devolutionMock = new ArrayList<>();

        //Act
        Mockito.when(characterRepository.findAllByNameContains(param)).thenReturn(devolutionMock);
        List<CharacterDTO> obtain = findService.find(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);

    }
}
