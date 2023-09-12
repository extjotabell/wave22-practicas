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
    public int idDeporte;

    public List<Persona> GetListPersona(){
        List<Persona> personaList = new ArrayList<>();
        personaList.add(new Persona("Sol","Recayte",30,1));
        personaList.add(new Persona("dani","Fimiani",30,2));
        personaList.add(new Persona("Orion","Fimiani",8,3));
        return  personaList;
    }
}
