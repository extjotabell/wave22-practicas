package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void find() {

        //ARRANGE
        List<CharacterDTO> listExpected = new ArrayList<>();
        List<CharacterDTO> listActual = new ArrayList<>();

        listExpected.add(TestUtil.generateCharacter());

        when(findService.find("luke")).thenReturn(listExpected);

        //ACT
        listActual = findController.find("luke");

        //ASSERT
        assertEquals(listExpected.size(),listActual.size());

    }
}