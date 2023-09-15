package com.calculadoraDeCalorias.calculadoraDeCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {
    private String name;
    private int calories;
}
