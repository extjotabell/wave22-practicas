package com.example.starwars.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeDTO {

    private String name;
    private double height, mass;
    private String gender, homeworld, species;


}
