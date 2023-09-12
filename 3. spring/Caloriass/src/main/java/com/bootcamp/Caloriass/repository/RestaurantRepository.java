package com.bootcamp.Caloriass.repository;

import com.bootcamp.Caloriass.entity.Ingrediente;
import com.bootcamp.Caloriass.entity.Plato;

public interface RestaurantRepository {
    Plato getPlatoLlamado(String nombrePlato);

    Ingrediente getIngredienteLlamado(String nombreIngrediente);
}
