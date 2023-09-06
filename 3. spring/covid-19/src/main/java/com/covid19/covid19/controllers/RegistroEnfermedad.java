package com.covid19.covid19.controllers;

import com.covid19.covid19.DTO.PersonaDTO;
import com.covid19.covid19.DTO.SintomaDTO;
import com.covid19.covid19.entidades.Persona;
import com.covid19.covid19.entidades.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegistroEnfermedad {

    List<Sintoma> sintomas = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public RegistroEnfermedad(){
        sintomas.add(new Sintoma(1,"Fiebre", 1));
        sintomas.add(new Sintoma(2,"Dolor",5));
        personas.add(new Persona(1,"Cecilia", "Morlacchi", 32,sintomas.get(0)));
        personas.add(new Persona(2,"Ivan","Basualdo",61,sintomas.get(1)));
    }
    @GetMapping("/findSymptom")
    ResponseEntity<List<SintomaDTO>> mostrarSintomas(){
        return ResponseEntity.ok(sintomas.stream().map(s-> new SintomaDTO(s.getNombre(),s.getNivel_de_gravedad())).toList());
    }

    @GetMapping("findSymptom/{name}")
    ResponseEntity<Integer> buscarSintoma(@PathVariable String name){
        return ResponseEntity.ok(sintomas.stream().filter(s -> s.getNombre().equals(name)).map(e-> new SintomaDTO(e.getNombre(),e.getNivel_de_gravedad())).findFirst().get().getNivel_de_gravedad());
    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<List<PersonaDTO>> personasRiesgo(){
        return ResponseEntity.ok(personas.stream()
                .filter(p-> p.getEdad() > 60 && p.getSintoma() != null)
                .map(e-> new PersonaDTO(e.getNombre() + " " + e.getApellido())).toList());
    }

}
