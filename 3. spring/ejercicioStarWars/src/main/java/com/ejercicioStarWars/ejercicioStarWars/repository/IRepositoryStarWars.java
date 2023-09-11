package com.ejercicioStarWars.ejercicioStarWars.repository;

import com.ejercicioStarWars.ejercicioStarWars.model.Personaje;

import java.util.List;

public interface IRepositoryStarWars {
    void loadDataBase();
    List<Personaje> getAllPersonajes();
}
