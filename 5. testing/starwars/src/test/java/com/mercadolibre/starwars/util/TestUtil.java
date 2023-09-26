package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class TestUtil {

    public static CharacterDTO generateCharacter(){
        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setName("LukeSkywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");

        return characterDTO;
    }
}
