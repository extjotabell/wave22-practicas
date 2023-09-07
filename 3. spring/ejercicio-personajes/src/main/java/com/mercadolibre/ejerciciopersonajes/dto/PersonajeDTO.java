package com.mercadolibre.ejerciciopersonajes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonajeDTO {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

}
