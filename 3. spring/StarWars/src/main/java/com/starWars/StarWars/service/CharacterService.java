package com.starWars.StarWars.service;

import com.starWars.StarWars.dtos.CharacterDTO;
import com.starWars.StarWars.models.Character;
import com.starWars.StarWars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    ICharacterRepository repo;

    @Override
    public List<CharacterDTO> findCharacter (String name) {
        List<Character> characters = repo.findCharacter(name);
        List<CharacterDTO> charactersDTO = characters.stream().map(c-> new CharacterDTO(c.getName(),c.getHeight(),c.getMass(),c.getGender(),c.getHomeworld(),c.getSpecies())).collect(Collectors.toList());
        return charactersDTO;
    }
}
