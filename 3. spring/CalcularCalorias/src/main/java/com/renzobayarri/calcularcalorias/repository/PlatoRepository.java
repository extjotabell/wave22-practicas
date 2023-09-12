package com.renzobayarri.calcularcalorias.repository;

import com.renzobayarri.calcularcalorias.model.Plato;

public interface PlatoRepository {

    Plato findPlatoByName(String name);
}
