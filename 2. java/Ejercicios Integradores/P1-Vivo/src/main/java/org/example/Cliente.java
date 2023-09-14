package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Localizador> localizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadores(){
        return localizadores;
    }

    public String getNombre(){
        return nombre;
    }
}
