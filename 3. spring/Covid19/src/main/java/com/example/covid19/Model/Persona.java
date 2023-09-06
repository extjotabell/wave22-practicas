package com.example.covid19.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private ArrayList<Sintoma> sintomas;
}
