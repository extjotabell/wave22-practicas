package com.example.ejerciciopracticogrupal.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiculoDTO {
    private String patente;

    private String marca;

    private String modelo;

    @JsonProperty(value = "fecha_fabricacion")
    private LocalDate fechaFabricacion;

    @JsonProperty(value = "cantidad_ruedas")
    private Integer cantidadRuedas;

    private List<SiniestroDTO> siniestros;
}
