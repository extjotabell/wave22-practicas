package com.mercadolibre.ejerciciopersonajes.repository;

import com.mercadolibre.ejerciciopersonajes.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> getAllPersonajesByName(String name);
    List<Personaje> getAllPersonajes();

}
