package com.example.starwars.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {

    private String name;
    private double height, mass;
    private String hairColor, skinColor, eyeColor, birthYear, gender, homeworld, species;


}
