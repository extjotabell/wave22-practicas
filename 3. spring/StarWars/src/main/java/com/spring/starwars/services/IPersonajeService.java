package com.spring.starwars.services;

import com.spring.starwars.entities.Personaje;

import java.util.List;

public interface IPersonajeService {
    List<Personaje> getPersonajesByWord(String word);
}
