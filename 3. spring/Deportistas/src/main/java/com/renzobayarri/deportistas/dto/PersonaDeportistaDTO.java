package com.renzobayarri.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeportistaDTO {

    private String nombre;

    private String apellido;

    private String deporte;

}
