package com.example.covid19.services;

import com.example.covid19.models.Persona;
import com.example.covid19.models.Sintoma;
import com.example.covid19.web.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServicesImp implements PersonaService {

    private List<Persona> personas;

    public PersonaServicesImp(){

        Sintoma sintoma1= new Sintoma(1,"Fatiga","bajo");
        Sintoma sintoma2 = new Sintoma(2,"mareo","intermedio");
        Sintoma sintoma3= new Sintoma(3,"fiebre","alto");

        Persona persona1 = new Persona(1,"Valentina","Gottelli",21,sintoma1);
        Persona persona2 = new Persona(2,"Juan","Perez",61,sintoma2);
        Persona persona3 = new Persona(3,"Monica","Zuc",45,sintoma3);

        this.personas = Arrays.asList(persona1,persona2,persona3);
    }
    @Override
    public List<PersonaDTO> findRiskPerson() {

        List<PersonaDTO> personasMayores60;

        personasMayores60 = personas.stream().filter(persona -> persona.getEdad() > 60).
                map(persona -> {
            String nombre = persona.getNombre();
            String apellido = persona.getApellido();
            String sintoma = persona.getSintoma().getNombre();
            int edad = persona.getEdad();
            return new PersonaDTO(nombre, apellido, sintoma , edad);
        }).collect(Collectors.toList());
        return personasMayores60;
    }

}

