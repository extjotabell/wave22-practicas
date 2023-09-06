package com.miprimerproyecto.pruebaspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private boolean tienePareja;
    private HashMap<String, String> dic;
    private List<String> list;
}
