package com.restaurant.calories.dto;

import com.restaurant.calories.model.Dish;
import com.restaurant.calories.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDetailsDTO {
    Double totalCalories;
    Map<Ingredient, Double> ingredients;
    Ingredient mostCaloric;

    public DishDetailsDTO(Dish dish, Double weight){
        totalCalories = 0.0;
        for (Map.Entry<Ingredient, Double> e : ingredients.entrySet()) {
            totalCalories += e.getKey().getCalories() * (e.getValue()/100) * weight;
        }
        mostCaloric = ingredients.entrySet().stream()
                .max(Map.Entry.comparingByKey(Comparator.comparing(x->x.getCalories()))).get().getKey();
    }
}
