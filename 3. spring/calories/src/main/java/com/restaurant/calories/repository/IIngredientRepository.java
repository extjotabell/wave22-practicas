package com.restaurant.calories.repository;

import com.restaurant.calories.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    Ingredient getIngredientByName(String name);
}
