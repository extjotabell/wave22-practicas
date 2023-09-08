package com.example.springpracticascalcucolorias.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ingrediente {
    private String name;
    private int calories;

    public Ingrediente() {

    }

    public Ingrediente(String nombre, int calorias) {
        this.name = nombre;
        this.calories = calorias;
    }
}
