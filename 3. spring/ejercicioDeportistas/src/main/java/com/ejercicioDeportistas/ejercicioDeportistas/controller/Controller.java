package com.ejercicioDeportistas.ejercicioDeportistas.controller;

import com.ejercicioDeportistas.ejercicioDeportistas.dto.DeporteDTO;
import com.ejercicioDeportistas.ejercicioDeportistas.dto.DeporteFullDTO;
import com.ejercicioDeportistas.ejercicioDeportistas.dto.PersonaDeporteDTO;
import com.ejercicioDeportistas.ejercicioDeportistas.model.Deporte;
import com.ejercicioDeportistas.ejercicioDeportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class Controller {
    List<Deporte> deportes = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public Controller() {
        deportes.add(new Deporte("Futbol", "Profesional"));
        deportes.add(new Deporte("Tenis", "Amateur"));
        deportes.add(new Deporte("Padel", "Amateur"));
        deportes.add(new Deporte("Basket", "Profesional"));
        deportes.add(new Deporte("Rugby", "Profesional"));

        personas.add(new Persona("Alejandro", "Hetman", 21, deportes.get(0)));
        personas.add(new Persona("Taylor", "Swift", 33, deportes.get(1)));
        personas.add(new Persona("Harry", "Styles", 29, deportes.get(2)));
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> showSports(){
        List<DeporteDTO> deporteDTO = deportes.stream()
                .map(deporte -> new DeporteDTO(deporte.getNombre()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> checkForSport(@PathVariable String name){
        Optional<DeporteFullDTO> deporte = deportes.stream()
                .filter(sport -> sport.getNombre().equals(name))
                .map(sport -> new DeporteFullDTO(sport.getNombre(), sport.getNivel()))
                .findFirst();

        if(deporte.isPresent()){
            return new ResponseEntity<>(deporte, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No existe ese deporte", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> showPersonsAndSports(){
        List<PersonaDeporteDTO> personasConDeporte = personas.stream()
                .map(persona -> new PersonaDeporteDTO(persona.getNombre(), persona.getApellido(), persona.getDeporteRealizado().getNombre()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(personasConDeporte, HttpStatus.OK);
    }
}
