package com.spring.deportistas.services.impl;

import com.spring.deportistas.entities.Deporte;
import com.spring.deportistas.entities.Nivel;
import com.spring.deportistas.entities.Persona;
import com.spring.deportistas.services.PersonaService;
import com.spring.deportistas.web.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    private List<Persona> personas;

    public PersonaServiceImpl() {
        Deporte deporte1 = new Deporte("Futbol", Nivel.FACIL);
        Deporte deporte2 = new Deporte("Natacion", Nivel.DIFICIL);
        Deporte deporte3 = new Deporte("Ajedrez", Nivel.FACIL);
        Deporte deporte4 = new Deporte("Basquet", Nivel.INTEMERDIO);
        Deporte deporte5 = new Deporte("Running", Nivel.FACIL);

        Persona p = new Persona("Julio", "Alvarez", 22, deporte1);
        Persona p1 = new Persona("Martin", "Marquez", 19, deporte2);
        Persona p2 = new Persona("Fabiano", "Caruana", 25, deporte3);
        Persona p3 = new Persona("Hikaru", "Nakamura", 30, deporte4);
        Persona p4 = new Persona("Anish", "Giri", 21, deporte5);
        this.personas = Arrays.asList(p, p1, p2, p3, p4);
    }

    @Override
    public List<PersonaDTO> findAllSportPeople() {
        List<PersonaDTO> personasDeportistas;
        personasDeportistas = personas.stream().map(persona -> {
            String nombre = persona.getNombre();
            String apellido = persona.getApellido();
            String nombreDeporte = persona.getDeporte().getNombre();
            return new PersonaDTO(nombre, apellido, nombreDeporte);
        }).collect(Collectors.toList());
        return personasDeportistas;
    }
}
