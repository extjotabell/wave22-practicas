package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find() {
        //ARRANGE
        String nombre = "Luke";
        List<CharacterDTO> listaPersonajeEsperada = new ArrayList<>();
        when(characterRepository.findAllByNameContains(nombre)).thenReturn(listaPersonajeEsperada);

        //ACT

        List<CharacterDTO> resultado = findService.find(nombre);

        //ASSERT

        assertEquals(listaPersonajeEsperada, resultado);
    }
}