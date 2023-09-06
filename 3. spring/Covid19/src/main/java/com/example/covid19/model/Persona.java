package com.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    private int id;
    private String nombre, apellido;
    private int edad;
    private List<Sintoma> listaSintomas;
}
