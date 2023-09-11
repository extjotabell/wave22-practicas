package com.example.ejerciciocomida.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dish {
    private String name;
    private Integer weigth;
    private List<Ingredient> ingredients;

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", weigth=" + weigth +
                ", ingredients=" + ingredients +
                '}';
    }
}
