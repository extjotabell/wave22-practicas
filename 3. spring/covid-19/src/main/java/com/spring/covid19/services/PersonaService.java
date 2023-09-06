package com.spring.covid19.services;

import com.spring.covid19.entities.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> findRiskPersons();
}
