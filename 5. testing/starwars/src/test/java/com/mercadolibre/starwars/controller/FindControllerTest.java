package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void find() {
        //ARRANGE
        String nombre = "Luke";
        List<CharacterDTO> listaPersonajesEsperada = new ArrayList<>();
        when(findService.find(nombre)).thenReturn(listaPersonajesEsperada);

        //ACT
        List<CharacterDTO> resultado = findController.find(nombre);

        //ARRANGE
        assertEquals(listaPersonajesEsperada, resultado);
    }
}