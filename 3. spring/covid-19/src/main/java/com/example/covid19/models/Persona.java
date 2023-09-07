package com.example.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {

    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;
}
