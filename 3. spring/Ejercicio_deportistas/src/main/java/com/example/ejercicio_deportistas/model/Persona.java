package com.example.ejercicio_deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre, apellido;
    private int edad;
}
