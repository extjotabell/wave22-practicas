package com.example.empresaseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaYModeloDTO {
    private String patente;
    private String marca;
    private String modelo;
}
