package com.example.ejerciciopracticogrupal.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroDTO {
    private String marca;
    private String modelo;
    private String patente;
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;
}
