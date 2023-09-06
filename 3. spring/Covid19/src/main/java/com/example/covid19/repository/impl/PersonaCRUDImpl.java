package com.example.covid19.repository.impl;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import com.example.covid19.repository.InterfaceCRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaCRUDImpl {

    List<Persona> listaPersonas = new ArrayList<>();
    SintomaCRUDImpl sintomaCRUD = SintomaCRUDImpl.getInstance();

    public void save(Persona objeto) {

        for (int i=0; i<objeto.getListaSintomas().size(); i++){
            sintomaCRUD.save(objeto.getListaSintomas().get(i));
        }
        listaPersonas.add(objeto);

    }


    public List<Persona> findRiskPerson() {
        return listaPersonas.stream().filter(persona -> persona.getEdad() >= 60).toList();
    }
}
