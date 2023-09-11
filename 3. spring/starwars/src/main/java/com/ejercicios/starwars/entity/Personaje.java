package com.ejercicios.starwars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {

    private String name;
    private Integer height;
    private Integer mass;
    private String hair_Color;
    private String skin_Color;
    private String eye_Color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public Personaje(String name, Integer height, Integer mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
