package com.example.ejerciciocomida.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Food {
    private String name;
    private Integer grams;
    private List<Ingredient> ingredientList;
}
