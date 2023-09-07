package com.bootcamp.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Persona {
    String nombre;
    String apellido;
    int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
