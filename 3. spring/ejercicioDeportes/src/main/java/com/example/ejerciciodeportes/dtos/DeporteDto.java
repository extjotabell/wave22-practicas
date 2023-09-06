package com.example.ejerciciodeportes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeporteDto {
    private String nombre;
    private int nivel;
}
