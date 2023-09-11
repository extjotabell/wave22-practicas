package com.starwars.characters.repository;

import com.starwars.characters.entity.MovieCharacter;

import java.util.List;

public interface ICharacterRepository {
    List<MovieCharacter> getCharactersByName(String name);
}
