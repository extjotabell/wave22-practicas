package com.example.starwars.controler;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starWars")
public class StarWarsControler {

    @Autowired
    IPersonajeService service;

    @GetMapping("/searchByName/{searchName}")
    public ResponseEntity<?> buscarPersonas(@PathVariable String searchName){
        List<PersonajeDTO> personajesDTOBySearchName = service.searchByName(searchName);
        return new ResponseEntity<>(personajesDTOBySearchName,HttpStatus.OK);
    }
}
