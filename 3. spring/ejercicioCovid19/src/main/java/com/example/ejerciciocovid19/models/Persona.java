package com.example.ejerciciocovid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;

}
