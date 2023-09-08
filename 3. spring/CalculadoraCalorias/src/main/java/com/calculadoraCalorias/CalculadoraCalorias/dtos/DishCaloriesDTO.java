package com.calculadoraCalorias.CalculadoraCalorias.dtos;

import com.calculadoraCalorias.CalculadoraCalorias.models.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishCaloriesDTO {
    private String name;
    private int totalCalories;
    private List<Food> ingredients;
    private String ingredientMostCalories;
}
