package com.example.automotriz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {
    private Long id;
    private LocalDate fecha;
    private double perdidaEconomica;
    private Long idVehiculoDenunciado;

}
