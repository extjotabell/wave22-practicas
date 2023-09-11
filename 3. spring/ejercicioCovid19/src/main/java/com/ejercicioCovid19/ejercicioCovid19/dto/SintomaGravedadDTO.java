package com.ejercicioCovid19.ejercicioCovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomaGravedadDTO {
    private String nombre;
    private int nivelDeGravedad;
}
