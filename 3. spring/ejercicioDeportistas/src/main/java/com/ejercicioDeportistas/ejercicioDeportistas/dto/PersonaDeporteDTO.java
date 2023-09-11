package com.ejercicioDeportistas.ejercicioDeportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonaDeporteDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
