package com.renzobayarri.starwars.repository;

import com.renzobayarri.starwars.model.Personaje;

import java.util.List;

public interface PersonajeRepository {

    List<Personaje> getAll();

    List<Personaje> getByName(String name);
}
