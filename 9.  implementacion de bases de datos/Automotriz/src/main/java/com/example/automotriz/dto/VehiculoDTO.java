package com.example.automotriz.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate anioDeFabricacion;
    private int cantidadDeRuedas;
}
