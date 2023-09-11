package com.example.ejerciciocomida.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {

    public Ingredient(String name){
        this.name = name;
    }

    private String name;
    private Integer calories;
}
