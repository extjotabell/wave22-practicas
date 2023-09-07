package com.example.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivelSeguridad;
}