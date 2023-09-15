package com.calculadoraDeCalorias.calculadoraDeCalorias.dto;

import com.calculadoraDeCalorias.calculadoraDeCalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DishDto {
    private int totalCalories;
    private List<Ingredient> ingredientList;
    private Ingredient mostCaloricIngredient;
}
