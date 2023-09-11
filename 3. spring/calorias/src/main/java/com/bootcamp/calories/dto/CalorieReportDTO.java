package com.bootcamp.calories.dto;

import com.bootcamp.calories.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CalorieReportDTO {
    private double totalCalories;
    private List<Ingredient> listOfIngredientsAndCalories;
    private String mostCaloricDish;
}
