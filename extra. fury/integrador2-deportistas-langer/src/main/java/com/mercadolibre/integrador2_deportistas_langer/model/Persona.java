package com.mercadolibre.integrador2_deportistas_langer.model;

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
