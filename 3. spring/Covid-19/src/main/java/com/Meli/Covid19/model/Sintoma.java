package com.Meli.Covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {
    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;

}
