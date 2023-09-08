package com.renzobayarri.calcularcalorias.repository;

import com.renzobayarri.calcularcalorias.model.Plato;

import java.util.List;

public interface PlatoRepository {

    Plato findPlatoByName(String name);

    List<Plato> getAll();
}
