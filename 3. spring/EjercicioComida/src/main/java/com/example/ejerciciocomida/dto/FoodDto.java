package com.example.ejerciciocomida.dto;

import com.example.ejerciciocomida.entity.Food;
import com.example.ejerciciocomida.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private String name;
    private List<IngredientDto> ingredients;
    private Integer grams;
}
