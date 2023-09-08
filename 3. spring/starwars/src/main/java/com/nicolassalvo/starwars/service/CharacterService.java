package com.nicolassalvo.starwars.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nicolassalvo.starwars.dto.CharacterDTO;
import com.nicolassalvo.starwars.model.Character;
import com.nicolassalvo.starwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@JsonInclude()
public class CharacterService implements ICharacterService{

    @Autowired
    ICharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getAllCharacters() {
        List<Character> characters = characterRepository.getAllCharacters();
        List<CharacterDTO> characterDTOList = new ArrayList<>();

        for (Character character : characters) {
            characterDTOList.add(new CharacterDTO(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies()));
        }


        return characterDTOList;
    }

    @Override
    public List<CharacterDTO> getCharactersByName(String name) {
        List<Character> characters = characterRepository.getCharactersByName(name);
        List<CharacterDTO> characterDTOList = new ArrayList<>();

        for (Character character : characters) {
            characterDTOList.add(new CharacterDTO(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies()));
        }

        return characterDTOList;
    }
}
