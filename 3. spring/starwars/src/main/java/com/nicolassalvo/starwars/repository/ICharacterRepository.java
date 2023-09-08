package com.nicolassalvo.starwars.repository;

import com.nicolassalvo.starwars.model.Character;

import java.util.List;

public interface ICharacterRepository {
    public List<Character> getAllCharacters();
    public List<Character> getCharactersByName(String name);
}
