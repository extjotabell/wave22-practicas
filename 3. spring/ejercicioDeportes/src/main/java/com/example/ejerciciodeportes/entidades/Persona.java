package com.example.ejerciciodeportes.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
}
