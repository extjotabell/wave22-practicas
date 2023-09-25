package com.personaje.personajedisney.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDto {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;
}

