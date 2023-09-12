package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Plato;

import java.util.List;

public interface PlatosRepository {
    List<Plato> getAllPlatos();

    Plato getPlatoLlamado(String nombre);
}
