package com.deportista.deportista.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    public String nombre;
    public String apellido;
    public int edad;
    public Deporte deporte;

}
