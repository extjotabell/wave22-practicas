package com.example.deportes.controller;

import com.example.deportes.dto.DeportistaDTO;
import com.example.deportes.models.Deporte;
import com.example.deportes.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private List<Deporte> deportes;
    private List<Persona> deportistas;
    private List<DeportistaDTO> deportistasDTO;

    public Controller() {

        Deporte futbol = new Deporte("Futbol", 2);
        Deporte voley = new Deporte("Voley", 1);
        Deporte tenis = new Deporte("Tenis", 3);

        this.deportes = new ArrayList<>(List.of(futbol, voley, tenis));

        Persona cami = new Persona("Camila", "Lemos", 19);
        Persona mati = new Persona("Matias", "Fernandez", 20);
        Persona gonza = new Persona("Gonzalo", "Herrera", 21);
        Persona nico = new Persona("Nicolas", "Guglielmi", 22);

        this.deportistas = new ArrayList<>(List.of(cami, mati, gonza, nico));

        DeportistaDTO camiDTO = new DeportistaDTO(cami.getNombre(), cami.getApellido(), voley.getNombre());
        DeportistaDTO matiDTO = new DeportistaDTO(mati.getNombre(), mati.getApellido(), futbol.getNombre());
        DeportistaDTO gonzaDTO = new DeportistaDTO(gonza.getNombre(), gonza.getApellido(), futbol.getNombre());
        DeportistaDTO nicoDTO = new DeportistaDTO(nico.getNombre(), nico.getApellido(), tenis.getNombre());

        this.deportistasDTO = new ArrayList<>(List.of(camiDTO, matiDTO, gonzaDTO, nicoDTO));

    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Integer> findSports(@PathVariable String name){

        Deporte deporteCoincidente = deportes.stream().filter( deporte -> deporte.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);

        if (deporteCoincidente != null) {
            return new ResponseEntity<>(deporteCoincidente.getNivel(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons(){
        return new ResponseEntity<>(deportistasDTO, HttpStatus.OK);
    }

}
