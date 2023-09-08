package com.example.starwars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Personaje {
    private String name;
    private String hairColor;
    private String skinColor;
    private String eyesColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
    private String height;
    private String mass;
}
