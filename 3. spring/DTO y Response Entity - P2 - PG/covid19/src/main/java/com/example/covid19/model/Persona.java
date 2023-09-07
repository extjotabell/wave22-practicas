package com.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;
}
