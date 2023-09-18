package com.renzobayarri.deportistas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deporte {

    private String nombre;

    private String nivel;
}