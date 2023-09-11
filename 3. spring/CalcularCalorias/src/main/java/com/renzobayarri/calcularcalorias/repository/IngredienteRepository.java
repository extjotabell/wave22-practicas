package com.renzobayarri.calcularcalorias.repository;

import com.renzobayarri.calcularcalorias.model.Ingrediente;

public interface IngredienteRepository {

    Ingrediente findIngredienteByName(String name);

}
