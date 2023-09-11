package com.starwars.characters.dto;

import com.starwars.characters.entity.MovieCharacter;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieCharacterDTO {
    String name;
    int  height;
    int mass;
    String gender;
    String homeworld;
    String species;

    public MovieCharacterDTO(MovieCharacter charac){
        this.name = charac.getName();
        this.height = charac.getHeight();
        this.mass = charac.getMass();
        this.gender = charac.getGender();
        this.homeworld = charac.getHomeworld();
        this.species = charac.getSpecies();
    }
}
