package com.nicolassalvo.starwars.controller;

import com.nicolassalvo.starwars.dto.CharacterDTO;
import com.nicolassalvo.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarwarsController {
    @Autowired
    ICharacterService characterService;

    @GetMapping("/characters")
    public ResponseEntity<?> getAllCharacters() {
        List<CharacterDTO> characterDTOList = characterService.getAllCharacters();
        return new ResponseEntity<>(characterDTOList, HttpStatus.OK);
    }
    @GetMapping("/characters/{name}")
    public ResponseEntity<?> getCharactersByName(@PathVariable String name) {
        List<CharacterDTO> characterDTOList = characterService.getCharactersByName(name);
        return new ResponseEntity<>(characterDTOList, HttpStatus.OK);
    }
}
