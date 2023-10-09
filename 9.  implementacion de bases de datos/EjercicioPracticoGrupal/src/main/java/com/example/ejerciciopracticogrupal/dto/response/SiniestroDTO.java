package com.example.ejerciciopracticogrupal.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDTO {

    private Long id;

    private LocalDate fecha;

    @JsonProperty(value = "perdida_economica")
    private Double perdidaEconomica;
}
