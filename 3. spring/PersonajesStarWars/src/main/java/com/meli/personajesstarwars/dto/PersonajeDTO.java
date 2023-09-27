package com.meli.personajesstarwars.dto;

import lombok.Data;

@Data
public class PersonajeDTO {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}