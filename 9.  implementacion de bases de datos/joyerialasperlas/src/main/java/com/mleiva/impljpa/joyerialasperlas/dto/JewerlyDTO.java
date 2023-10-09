package com.mleiva.impljpa.joyerialasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter @Setter
public class JewerlyDTO {
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    private boolean ventaONo;
}
