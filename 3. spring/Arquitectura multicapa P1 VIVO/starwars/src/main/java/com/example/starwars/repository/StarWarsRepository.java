package com.example.starwars.repository;

import com.example.starwars.model.Personaje;

import java.util.List;

public interface StarWarsRepository {

    List<Personaje> getAllByName(String name);
    List<Personaje> getAll();
}
