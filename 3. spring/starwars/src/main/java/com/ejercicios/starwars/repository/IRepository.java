package com.ejercicios.starwars.repository;


import com.ejercicios.starwars.entity.Personaje;

import java.util.List;

public interface IRepository {

    List<Personaje> getAll();
    List<Personaje> findByName(String name);
    void save(Personaje personaje);
}
