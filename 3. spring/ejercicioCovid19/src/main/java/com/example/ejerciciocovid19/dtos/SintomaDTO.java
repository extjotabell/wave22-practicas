package com.example.ejerciciocovid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomaDTO {
    private String nombre;
    private Integer nivel_de_gravedad;
}
