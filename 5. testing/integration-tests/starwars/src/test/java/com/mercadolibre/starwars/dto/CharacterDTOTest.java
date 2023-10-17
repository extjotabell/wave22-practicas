package com.mercadolibre.starwars.dto;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterDTOTest {

    private CharacterDTO characterDTO;

    @BeforeEach
    void setUp() {
        characterDTO = new CharacterDTO();
    }

    @Test
    @DisplayName("Test CharacterDTO - Getters and Setters")
    void testCharacterDTOGettersAndSetters() {
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHair_color("Blond");
        characterDTO.setSkin_color("Fair");
        characterDTO.setEye_color("Blue");
        characterDTO.setBirth_year("19 BBY");
        characterDTO.setGender("Male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);

        assertEquals("Luke Skywalker", characterDTO.getName());
        assertEquals("Blond", characterDTO.getHair_color());
        assertEquals("Fair", characterDTO.getSkin_color());
        assertEquals("Blue", characterDTO.getEye_color());
        assertEquals("19 BBY", characterDTO.getBirth_year());
        assertEquals("Male", characterDTO.getGender());
        assertEquals("Tatooine", characterDTO.getHomeworld());
        assertEquals("Human", characterDTO.getSpecies());
        assertEquals(172, characterDTO.getHeight());
        assertEquals(77, characterDTO.getMass());
    }
}
