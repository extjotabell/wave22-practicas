package com.example.covid19.controller;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SintomaControler {

    List<Sintoma> sintomas = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    @GetMapping("/cargarSintomas")
    public void cargarSintomas(){
        Sintoma sintoma1 = new Sintoma(1,"Sintoma1",5);
        Sintoma sintoma2 = new Sintoma(2,"Sintoma2",4);
        Sintoma sintoma3 = new Sintoma(3,"Sintoma3",3);
        sintomas.add(sintoma1);
        sintomas.add(sintoma2);
        sintomas.add(sintoma3);
    }

    @GetMapping("/cargarPersonas")
    public void cargarPersonas(){
        Persona persona1 = new Persona(1,"Pedro","Gonzalez",65);
        Persona persona2 = new Persona(2,"Juan","Rodriguez",55);
        Persona persona3 = new Persona(3,"Martin","Messi",75);
        Persona persona4 = new Persona(4,"Jorge","Martinez",85);
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
    }

    @GetMapping("/findSymptom")
    public List<Sintoma> findSymptom(){
        return sintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public Sintoma findSymptom(@PathVariable String name){
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getNombre().equals(name))return sintoma;
        }
        return null;
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> personasDeRiesgo(){
        List<PersonaDTO> personasDeRiesgo = new ArrayList<>();
        for (Persona persona: personas) {
            if (persona.getEdad()>60){
                personasDeRiesgo.add(new PersonaDTO(persona.getNombre(),persona.getApellido()));
            }
        }
        return personasDeRiesgo;
    }
}
