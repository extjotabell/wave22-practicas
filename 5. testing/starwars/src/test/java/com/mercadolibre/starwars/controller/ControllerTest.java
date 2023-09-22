package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findOk(){
        String query = "Luke";
        List<CharacterDTO> expectedReturn = List.of(new CharacterDTO("Luke Skywalker",172,77,"blond","fair","blue","19BBY","male","Tatooine","Human"));
        when(service.find(query)).thenReturn(expectedReturn);

        List<CharacterDTO> actual = controller.find(query);

        Assertions.assertTrue(CollectionUtils.isEqualCollection(expectedReturn,actual));
    }
}
