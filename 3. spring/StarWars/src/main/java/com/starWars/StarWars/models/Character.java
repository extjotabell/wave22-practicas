package com.starWars.StarWars.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    private String name;
    private int height;
    private int mass;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String hair_color;
    private String gender;
    private String homeworld;
    private String species;

}
