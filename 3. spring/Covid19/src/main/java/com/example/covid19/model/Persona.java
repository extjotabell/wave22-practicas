package com.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
