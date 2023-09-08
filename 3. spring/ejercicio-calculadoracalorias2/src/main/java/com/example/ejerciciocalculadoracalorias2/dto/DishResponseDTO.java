package com.example.ejerciciocalculadoracalorias2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishResponseDTO {

    private String name;
    private List<IngredientDTO> ingredients;
    private double totalCalories;
    private IngredientDTO maxCaloriesIngredient;
}

