package com.mercadolibre.starwars.utils;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactoryHelper {

    public static List<CharacterDTO> createSampleCharacterList() {
        List<CharacterDTO> sampleCharacters = new ArrayList<>();

        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("19BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        character1.setHeight(172);
        character1.setMass(77);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Leia Organa");
        character2.setHair_color("Brown");
        character2.setSkin_color("Light");
        character2.setEye_color("Brown");
        character2.setBirth_year("19 BBY");
        character2.setGender("Female");
        character2.setHomeworld("Alderaan");
        character2.setSpecies("Human");
        character2.setHeight(150);
        character2.setMass(49);

        sampleCharacters.add(character1);
        sampleCharacters.add(character2);

        return sampleCharacters;
    }
}
