package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;

import java.util.List;

public interface CaloryRepository {

    Plato obtenerPlatoPorNombre(String nombrePlato);
}
