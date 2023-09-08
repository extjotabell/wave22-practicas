package com.example.starwars.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PersonajeDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private String height;
    private String mass;
}
