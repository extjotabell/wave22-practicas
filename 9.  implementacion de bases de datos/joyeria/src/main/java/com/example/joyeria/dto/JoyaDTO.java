package com.example.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {

    @JsonIgnore
    private Long nro_identificatorio;

    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
