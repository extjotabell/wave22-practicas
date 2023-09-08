package com.starWars.StarWars.controller;

import com.starWars.StarWars.dtos.CharacterDTO;
import com.starWars.StarWars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterService service;

    @GetMapping("/findByName")
    public List<CharacterDTO> findCharacter (@RequestParam String name){
        return service.findCharacter(name);
    }
}
