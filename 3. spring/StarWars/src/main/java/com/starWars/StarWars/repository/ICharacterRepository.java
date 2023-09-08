package com.starWars.StarWars.repository;

import com.starWars.StarWars.models.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> findCharacter(String name);
}
