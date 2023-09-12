package com.ejercicios.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDTO {

    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}
