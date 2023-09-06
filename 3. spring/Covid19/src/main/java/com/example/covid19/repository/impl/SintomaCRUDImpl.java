package com.example.covid19.repository.impl;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import com.example.covid19.repository.InterfaceCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SintomaCRUDImpl implements InterfaceCRUD<Sintoma> {

    private static SintomaCRUDImpl instanciaImpl = null;

    public static SintomaCRUDImpl getInstance(){
        if(instanciaImpl == null){
            instanciaImpl = new SintomaCRUDImpl();
        }
        return instanciaImpl;
    }

    List<Sintoma> listaSintomas = new ArrayList<>();

    @Override
    public void save(Sintoma objeto) {
        listaSintomas.add(objeto);
    }

    public Optional<Sintoma> findSymptom(String name){
        return listaSintomas.stream().filter(s -> s.getNombre().equalsIgnoreCase(name)).findFirst();
    }

    public List<Sintoma> findSymptoms(){
        return listaSintomas;
    }
}
