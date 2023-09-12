package com.covid.covid19.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private String nivelDegravedad;

}
