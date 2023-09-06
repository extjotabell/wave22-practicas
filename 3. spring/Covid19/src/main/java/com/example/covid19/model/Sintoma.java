package com.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;
}
