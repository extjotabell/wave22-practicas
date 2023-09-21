package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterReposiotoryTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContains(){
        //Arrange
        List<CharacterDTO> characterDTOSExpected = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");

        characterDTOSExpected.add(characterDTO);

        String name = "Luke";

        //ACT

        List<CharacterDTO> obtained = characterRepository.findAllByNameContains(name);

        //Assert

        assertEquals(characterDTOSExpected,obtained);

    }
}
