package com.starwars.characters.repository;

import com.starwars.characters.CharactersApplication;
import com.starwars.characters.entity.MovieCharacter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CharacterRepository implements ICharacterRepository{
    @Override
    public List<MovieCharacter> getCharactersByName(String name) {
        return CharactersApplication.characters.stream()
                .filter(x->x.getName().toLowerCase()
                        .contains(name.toLowerCase())).collect(Collectors.toList());
    }
}
