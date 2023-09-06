package com.example.covid19.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
