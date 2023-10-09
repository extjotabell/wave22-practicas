package com.example.ejerciciohql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroResponseDTO {

    private Long id;
    private LocalDate fecha;
    private double perdidaEconomica;
}
