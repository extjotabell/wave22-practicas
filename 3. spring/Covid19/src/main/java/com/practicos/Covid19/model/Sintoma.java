package com.practicos.Covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {

    private String codigo;
    private String nombre;
    private String nivel_de_seguridad;
}
