package com.personaje.personajedisney.Controller;

import com.personaje.personajedisney.Dto.PersonajeDto;
import com.personaje.personajedisney.Interface.IPersonajeService;
import com.personaje.personajedisney.Models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    IPersonajeService service;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDto>> GetPersonaje(@PathVariable String name){
        return new ResponseEntity<>(service.GetPersonaje(name), HttpStatus.OK);
        }
}
