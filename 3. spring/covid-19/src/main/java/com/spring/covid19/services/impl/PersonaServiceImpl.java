package com.spring.covid19.services.impl;

import com.spring.covid19.entities.Gravedad;
import com.spring.covid19.entities.Persona;
import com.spring.covid19.entities.Sintoma;
import com.spring.covid19.services.PersonaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    private List<Persona> personas;

    public PersonaServiceImpl() {
        Sintoma s1 = new Sintoma("A001", "Dolor de cabeza", Gravedad.MEDIA);
        Sintoma s2 = new Sintoma("B002", "Nausea", Gravedad.BAJA);
        Sintoma s3 = new Sintoma("Z203", "Perdida de olfato", Gravedad.BAJA);
        Sintoma s4 = new Sintoma("XR09", "Escalofrios", Gravedad.MEDIA);
        Sintoma s5 = new Sintoma("MN04", "Convulsion", Gravedad.ALTA);

        Persona p1 = new Persona(1L, "Jorge", "Tevez", 70, s1);
        Persona p2 = new Persona(2L, "Valentin", "Barco", 19, s2);
        Persona p3 = new Persona(3L, "Marcos", "Martinez", 82, s5);
        Persona p4 = new Persona(4L, "Franco", "Lopez", 60, s4);
        Persona p5 = new Persona(5L, "Martin", "Marquez", 19, s3);

        this.personas = Arrays.asList(p1, p2, p3, p4, p5);
    }

    @Override
    public List<Persona> findRiskPersons() {
        List<Persona> personasDeRiesgo;
        personasDeRiesgo = personas.stream().filter(p -> p.getEdad() > 60).collect(Collectors.toList());
        return personasDeRiesgo;
    }
}
