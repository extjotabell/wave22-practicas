package com.bootcamp.calories.repository;

import com.bootcamp.calories.model.Dish;
import com.bootcamp.calories.model.Ingredient;

import java.util.List;

public interface IDishRepository {
    List<Dish> getAllDishes();
    Dish getDishByName(String name);
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientByName(String name);
}
