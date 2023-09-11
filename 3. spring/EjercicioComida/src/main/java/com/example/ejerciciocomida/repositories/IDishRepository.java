package com.example.ejerciciocomida.repositories;

import com.example.ejerciciocomida.entities.Dish;
import com.example.ejerciciocomida.entities.Ingredient;

import java.util.List;

public interface IDishRepository {
    List<Ingredient> getIngredients(String name);
    Dish getDish(String name);
    List<Dish> getAllDishes();
}
