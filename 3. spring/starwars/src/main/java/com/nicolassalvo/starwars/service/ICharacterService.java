package com.nicolassalvo.starwars.service;

import com.nicolassalvo.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    public List<CharacterDTO> getAllCharacters();

    public List<CharacterDTO> getCharactersByName(String name);
}
