package com.starwars.characters.entity;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
public class MovieCharacter {
    String name;
    int  height;
    int mass;
    String hairColor;
    String skinColor;
    String eyeColor;
    String birthYear;
    String gender;
    String homeworld;
    String species;
}
