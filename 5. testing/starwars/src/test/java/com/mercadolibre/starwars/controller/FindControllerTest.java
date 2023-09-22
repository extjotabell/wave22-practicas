package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
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
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findOkTest(){
        //Arrange
        String param = "Luke";
        List<CharacterDTO> devolution = new ArrayList<>();
        List<CharacterDTO> devolutionMock = new ArrayList<>();
        devolution.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));
        devolutionMock.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));

        //Act
        Mockito.when(findService.find(param)).thenReturn(devolutionMock);
        List<CharacterDTO> obtain = findController.find(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);
    }

    @Test
    void findEmptyTest(){
        //Arrange
        String param = "Lukeasdasdasdasd";
        List<CharacterDTO> devolution = new ArrayList<>();
        List<CharacterDTO> devolutionMock = new ArrayList<>();

        //Act
        Mockito.when(findService.find(param)).thenReturn(devolutionMock);
        List<CharacterDTO> obtain = findController.find(param);

        //Assert
        Assertions.assertEquals(devolution,obtain);
    }
}
