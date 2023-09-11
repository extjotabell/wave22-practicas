package com.restaurant.calories.repository;

import com.restaurant.calories.dto.DishDetailsDTO;
import com.restaurant.calories.model.Ingredient;

public interface IDishDetailRepository {
    DishDetailsDTO getIngredientByName(String name);

}
