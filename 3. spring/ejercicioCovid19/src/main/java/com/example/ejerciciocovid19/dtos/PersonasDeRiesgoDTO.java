package com.example.ejerciciocovid19.dtos;
import com.example.ejerciciocovid19.models.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonasDeRiesgoDTO {
    private String nombreCompleto;
    private Integer edad;
    private ArrayList<Sintoma> sintomas;
}
