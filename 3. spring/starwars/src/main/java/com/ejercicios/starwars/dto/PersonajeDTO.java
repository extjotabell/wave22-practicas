package com.ejercicios.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDTO {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String home_world;
    private String species;
}