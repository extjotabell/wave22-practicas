package com.example.ApiDeportista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
