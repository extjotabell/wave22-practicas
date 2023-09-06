package com.practico.deportistas.controller;

import com.practico.deportistas.dto.DeporteDTO;
import com.practico.deportistas.dto.DeportesDTO;
import com.practico.deportistas.dto.PersonaDTO;
import com.practico.deportistas.model.Deporte;
import com.practico.deportistas.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deportista")

public class DeportistasController {

    List<Persona> personaList = new ArrayList<>();
    List<Deporte> deporteList = new ArrayList<>();

    public DeportistasController() {
        personaList.add(new Persona("Sol","Recayte",30,new Deporte("Futbol","Medio")));
        personaList.add(new Persona("Vale","Gottelli",25,new Deporte("Voley","Dificil")));
        personaList.add(new Persona("Julio","Jalvare",23,new Deporte("Paddel","Facil")));

        deporteList.add(new Deporte("Futbol","Intermedio"));
        deporteList.add(new Deporte("Hockey","Intermedio"));
        deporteList.add(new Deporte("Ajedrez","Dificil"));
        deporteList.add(new Deporte("Natacion","Facil"));
    }

    @GetMapping()
    public ResponseEntity<List<DeporteDTO>> AllDeporte(){
        List<DeporteDTO> deporteDTOS = deporteList.stream().map(deporte -> new DeporteDTO(deporte.getNombre(),deporte.getNivel())).toList();
        return ResponseEntity.ok(deporteDTOS);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DeporteDTO> findDeporteByName(@PathVariable String name){
        Deporte deporte1 = deporteList.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst().orElse(null);
        DeporteDTO deporteDTO = new DeporteDTO(deporte1.getNombre(),deporte1.getNivel());
        return ResponseEntity.ok(deporteDTO);
    }

    @GetMapping("/findsportspersons")
    public ResponseEntity<List <PersonaDTO>> findSportsPersons(){
        List<PersonaDTO> personaDTOS = personaList.stream()
                .map(persona -> {
                    DeportesDTO deportesDTO = convertirDeporte(persona.getDeporte());
                    return new PersonaDTO(persona.getNombre(), persona.getApellido(), deportesDTO);
                    }).collect(Collectors.toList());
        return ResponseEntity.ok(personaDTOS);
    }
    private DeportesDTO convertirDeporte(Deporte deporte) {
        DeportesDTO deportesDTO = new DeportesDTO();
        deportesDTO.setNombre(deporte.getNombre());
        return deportesDTO;
    }



}




