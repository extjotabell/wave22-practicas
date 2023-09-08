package com.meli.calculadoracalorias.repository;

import com.meli.calculadoracalorias.model.Ingredient;
import com.meli.calculadoracalorias.model.Plato;

import java.util.List;

public interface IPlatoRepository {
    List<Ingredient> getAllIngredients();
    List<Plato> getAllPlatos();
    Plato getPlato(String name, Double weight);
    Plato createPlato(List<Ingredient> ingredients, String name, Double weight);
}
