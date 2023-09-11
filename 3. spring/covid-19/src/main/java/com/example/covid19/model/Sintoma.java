package com.example.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

    public Sintoma(String nombre){
        this.nombre = nombre;
    }
}
