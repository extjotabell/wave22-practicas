package com.covid19.covid19.repositorios;

import com.covid19.covid19.entidades.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class RepositorioSintoma {

    public static List<Sintoma> sintomas = new ArrayList<>();

    public void agregarSintomas(Sintoma sintoma){
        sintomas.add(sintoma);
    }

    public static List<Sintoma> getSintomas() {
        return sintomas;
    }

    public static boolean buscarSintoma(String nombre){
        boolean sintoma = sintomas.stream().anyMatch(s-> s.getNombre().equals(nombre));
        return sintoma;
    }
}
