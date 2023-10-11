package com.example.empresaseguros.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class SiniestroDTO {

    @JsonIgnore
    private Integer id_siniestro;

    private LocalDate fecha;
    private Double perdidaEconomica;
    // private Integer id_vehículo_denunciado;
}
