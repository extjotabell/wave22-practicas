package com.starwars.characters.service;

import com.starwars.characters.dto.MovieCharacterDTO;
import com.starwars.characters.entity.MovieCharacter;

import java.util.List;

public interface ICharacterService {
    List<MovieCharacterDTO> getMovieCharactersByName(String name);
}
