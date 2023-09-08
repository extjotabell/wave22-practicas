package com.Meli.Covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private String id;
    private String nombre;
    private  String apellido;
    private  int edad;

}
