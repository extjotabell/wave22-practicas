package com.example.covid_19.dto;

import java.util.ArrayList;
import java.util.List;

public class SintomasDTO {

    List<SintomaDTO> listaSintomas = new ArrayList<>();
    public void agregarSintomas(SintomaDTO sintoma){
        this.listaSintomas.add(sintoma);
    }
    public List<SintomaDTO> getListaSintomas() {
        return this.listaSintomas;
    }

    public void setSintomas(List<SintomaDTO> sintomas) {
        this.listaSintomas = sintomas;
    }

}
