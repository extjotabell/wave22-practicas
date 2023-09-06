package com.example.deportistas.controler;

import com.example.deportistas.dto.PersonaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistaControler {

    List<Deporte> deportes = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public DeportistaControler() {
        deportes.add(new Deporte(1,"Futbol",1));
        deportes.add(new Deporte(2,"Basquet",2));
        deportes.add(new Deporte(3,"Tenis",3));
        personas.add(new Persona("Pedro","Gonzalez",25,1));
        personas.add(new Persona("Juan","Rodriguez",35,2));
        personas.add(new Persona("Jorge","Luna",45,3));
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> findAllSports(){
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> findSportsByName(@PathVariable String name){
        for (Deporte deporte : deportes) {
            if (deporte.getNombre().equals(name)) return new ResponseEntity<>(deporte, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){
        List<PersonaDTO> personasDeportistas = new ArrayList<>();
        for (Persona persona : personas) {
            personasDeportistas.add(new PersonaDTO(persona.getNombre(),persona.getApellido(),deportes.get(persona.getIdDeporte()-1).getNombre()));
        }
        return new ResponseEntity<>(personasDeportistas, HttpStatus.OK);
    }

}
