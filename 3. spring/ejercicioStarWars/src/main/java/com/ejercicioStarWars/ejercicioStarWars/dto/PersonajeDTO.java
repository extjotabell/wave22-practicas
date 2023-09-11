package com.ejercicioStarWars.ejercicioStarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;
}
