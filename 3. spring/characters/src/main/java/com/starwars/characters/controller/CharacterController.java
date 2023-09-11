package com.starwars.characters.controller;

import com.starwars.characters.CharactersApplication;
import com.starwars.characters.dto.MovieCharacterDTO;
import com.starwars.characters.entity.MovieCharacter;
import com.starwars.characters.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CharacterController {
    @Autowired
    ICharacterService service;

    @GetMapping("/character/{name}")
    public ResponseEntity<List<MovieCharacterDTO>> getMovieCharacters(@PathVariable String name){
        return new ResponseEntity<>(getMovieCharacterlist(name), HttpStatus.OK);
    }

    private List<MovieCharacterDTO> getMovieCharacterlist(String name){

        List<MovieCharacterDTO> characterDTOList = service.getMovieCharactersByName(name);

        return characterDTOList;
    }
}
