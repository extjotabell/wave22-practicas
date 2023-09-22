package com.example.prueba_concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    private int identificador;
    private String marca;
    private String modelo;
    private String matrícula;
    private String color;
    private LocalDate año_de_fabricación;
    private double velocidad_máxima;
    private int capacidad_de_personas;
    private String combustible;
    private String transmisión;

}
