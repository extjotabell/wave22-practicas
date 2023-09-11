package com.starwars.characters.service;

import com.starwars.characters.CharactersApplication;
import com.starwars.characters.dto.MovieCharacterDTO;
import com.starwars.characters.entity.MovieCharacter;
import com.starwars.characters.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService{
    @Autowired
    ICharacterRepository repo;
    @Override
    public List<MovieCharacterDTO> getMovieCharactersByName(String name) {

        List<MovieCharacter> characterList = repo.getCharactersByName(name);

        List<MovieCharacterDTO> characterDTOList = new ArrayList<>();

        for (MovieCharacter mc: characterList) {
            characterDTOList.add(new MovieCharacterDTO(mc));
        }
        return characterDTOList;

    }
}
