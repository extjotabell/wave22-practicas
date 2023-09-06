package com.deportes.deportes.controller;

import com.deportes.deportes.dto.DeporteDTO;
import com.deportes.deportes.dto.PersonaDTO;
import com.deportes.deportes.models.Deporte;
import com.deportes.deportes.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private List<Deporte> deportes = new ArrayList<>();

    private List<Persona> personas = new ArrayList<>();

    public Controller() {
        deportes.add(new Deporte("Football", "Fácil"));
        deportes.add(new Deporte("Basket", "Dificil"));
        personas.add(new Persona("Carlos", "Villagran", 77, deportes.get(0)));
        personas.add(new Persona("Pedro", "Perez", 22, deportes.get(1)));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> getAllDeportes(){
        return ResponseEntity.ok(deportes.stream().map(d -> new DeporteDTO(d.getNombre(), d.getNivel())).toList());
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<String> getLevel(@PathVariable String nombre){
        return new ResponseEntity<>(deportes.stream().filter(d -> d.getNombre().equals(nombre)).findFirst().get().getNivel(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<PersonaDTO>> getPersonasDeportistas(){
        return ResponseEntity.ok(personas.stream()
                .filter(p ->p.getDeporte() != null)
                .map(p->new PersonaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()))
                .toList());
    }
}
