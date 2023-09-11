package com.bootcamp.calories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@AllArgsConstructor
@Data
public class Dish {
    private String name;
    private Map<Ingredient, Double> proportions;
}
