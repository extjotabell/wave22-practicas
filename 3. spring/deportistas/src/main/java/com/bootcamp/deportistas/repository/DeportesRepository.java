package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.DTO.DeporteDTO;
import com.bootcamp.deportistas.model.Deportee;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

public class DeportesRepository {
    List<Deportee> listaDeDeportes = new ArrayList<Deportee>();

    public void agregarDeporte(Deportee nuevoDeporte){
        listaDeDeportes.add(nuevoDeporte);
    }

    public List<DeporteDTO> getListaDeDeportesDTO() {
        List < DeporteDTO> listaResultado = new ArrayList<>();
        for (Deportee depo : listaDeDeportes){
            listaResultado.add(new DeporteDTO(depo));
        }
        return listaResultado;
    }

    public String getNivelDeDeporte(String name){
        for (Deportee depo : listaDeDeportes){
            if (depo.getNombre().equals(name)){
                return depo.getNivel();
            }
        }
        return "";
    }
}
