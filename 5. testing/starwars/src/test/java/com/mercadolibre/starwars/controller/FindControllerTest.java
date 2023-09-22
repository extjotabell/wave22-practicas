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
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findTestOk(){
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        Mockito.when(service.find("Luke")).thenReturn(characterDTOList);

        Assertions.assertEquals(characterDTOList, controller.find("Luke"));
    }

    @Test
    void findTestEmpty(){
        Mockito.when(service.find("asdasdas")).thenReturn(List.of());

        Assertions.assertTrue(controller.find("asdasdas").isEmpty());
    }
}
