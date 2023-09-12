package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;
import java.util.List;

public interface CaloryRepository {

    List<Ingrediente> obtenerTodosIngredientes();
    Ingrediente obtenerIngredientePorNombre(String name);
}
