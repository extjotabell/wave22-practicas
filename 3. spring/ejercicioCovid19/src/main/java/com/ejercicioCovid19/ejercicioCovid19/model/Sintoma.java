package com.ejercicioCovid19.ejercicioCovid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivelDeGravedad;
}
