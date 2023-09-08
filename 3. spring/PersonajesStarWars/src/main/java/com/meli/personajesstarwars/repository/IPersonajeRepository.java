package com.meli.personajesstarwars.repository;

import com.meli.personajesstarwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();
    List<Personaje> findByName(String name);
}
