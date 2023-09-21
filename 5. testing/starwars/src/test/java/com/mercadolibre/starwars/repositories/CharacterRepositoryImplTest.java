package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains() {
        //ARRANGE
        List<CharacterDTO> listaPersonajesEsperada = new ArrayList<>();

        CharacterDTO characterDTO = new CharacterDTO("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY","male","Tatooine","Human");

        listaPersonajesEsperada.add(characterDTO);

        String nombre = "Luke";

        //ACT

        List<CharacterDTO> resultado = characterRepository.findAllByNameContains(nombre);

        //ASSERT

        Assertions.assertTrue(CollectionUtils.isEqualCollection(listaPersonajesEsperada, resultado));

    }
}