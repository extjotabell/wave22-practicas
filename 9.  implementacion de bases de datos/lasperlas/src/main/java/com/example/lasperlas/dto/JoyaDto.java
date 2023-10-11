package com.example.lasperlas.dto;

import lombok.Data;

@Data
public class JoyaDto {
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo = Boolean.TRUE;
}
