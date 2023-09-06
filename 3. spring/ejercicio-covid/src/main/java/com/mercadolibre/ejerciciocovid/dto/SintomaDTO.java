package com.mercadolibre.ejerciciocovid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomaDTO {

    private int codigo;
    private String nombre;
    private int nivelDeGravedad;

}
