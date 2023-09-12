package com.ejercicios.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private LocalDate date;
    private Double kilometers;
    private String  descriptions;
}
