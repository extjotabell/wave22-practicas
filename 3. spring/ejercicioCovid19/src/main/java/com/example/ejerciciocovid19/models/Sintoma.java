package com.example.ejerciciocovid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {
    private String codigo;
    private String nombre;
    private Integer nivel_de_gravedad;
}
