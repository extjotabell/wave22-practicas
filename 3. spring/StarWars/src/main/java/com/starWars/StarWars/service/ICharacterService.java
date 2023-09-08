package com.starWars.StarWars.service;

import com.starWars.StarWars.dtos.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> findCharacter (String name);
}
