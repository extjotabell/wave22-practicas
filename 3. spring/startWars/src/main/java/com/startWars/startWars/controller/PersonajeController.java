package com.startWars.startWars.controller;

import com.startWars.startWars.dto.PersonajeDTO;
import com.startWars.startWars.service.IPersonajeService;
import com.startWars.startWars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> getPersonajesPorNombre(@RequestParam String nombre){
        List<PersonajeDTO> personajes = personajeService.buscarPorNombre(nombre);
        return new ResponseEntity<>(personajes, HttpStatus.OK);
    }
}
