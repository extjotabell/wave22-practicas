package com.calculadoraDeCalorias.calculadoraDeCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
}
