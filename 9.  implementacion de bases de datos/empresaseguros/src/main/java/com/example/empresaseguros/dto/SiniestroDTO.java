package com.example.empresaseguros.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class SiniestroDTO {

    @JsonIgnore
    private Integer id_siniestro;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;
    private Double perdidaEconomica;
    private Integer id_vehículo_denunciado;
}
