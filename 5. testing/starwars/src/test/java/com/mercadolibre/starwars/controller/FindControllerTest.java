package com.mercadolibre.starwars.controller;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService service;
    @InjectMocks
    FindController controller;

    @Test
    void findTest() throws IOException {
        // Arrange
        String query = "Luke";
        List<CharacterDTO> repoReturn = new ArrayList<>();
        repoReturn.add(new CharacterDTO("Luke Skywalker", null,null,null,null,null,null,null,null,null));

        when(service.find(anyString())).thenReturn(repoReturn);

        // Act
        List<CharacterDTO> actual = controller.find(query);

        // Assert
        assertEquals(repoReturn, actual);
    }

    @Test
    void findEmptyTest() {
        // ARRANGE
        List<CharacterDTO> emptyList = new ArrayList<>();
        final String param ="XXXXXXX";
        when(service.find(param)).thenReturn(emptyList);
        // ACT
        List<CharacterDTO> current = service.find(param);
        // ASSERT
        Assertions.assertEquals(0, current.size());

    }



}
