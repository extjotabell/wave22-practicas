package com.example.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int idDeporte;
}
