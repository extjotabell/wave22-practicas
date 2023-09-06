package com.spring.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;
}
