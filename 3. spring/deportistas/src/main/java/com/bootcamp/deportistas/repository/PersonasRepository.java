package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deportee;
import com.bootcamp.deportistas.model.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
public class PersonasRepository {
    Map<Persona, Deportee> mapaDePersonas = new HashMap<Persona, Deportee>();

    public void agregarPersonaYSuDeporte(Persona persona, Deportee deporte){
        mapaDePersonas.put(persona, deporte);
    }

    public List<Persona> getListaDePersonas(){
        List<Persona> listaARetornar = new ArrayList<>(mapaDePersonas.keySet());
        return listaARetornar;
    }

    public List<Persona> getDeportistas(){
        List<Persona> listaARetornar = new ArrayList<>();
        for (Persona persona : mapaDePersonas.keySet()){
            if(mapaDePersonas.get(persona) != null) {
                listaARetornar.add(persona);
            }
        }
        return listaARetornar;
    }

    public Deportee getDeporteDePersona(Persona persona){
        return mapaDePersonas.get(persona);
    }
}
