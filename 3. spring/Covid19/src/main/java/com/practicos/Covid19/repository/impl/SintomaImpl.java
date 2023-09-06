package com.practicos.Covid19.repository.impl;

import com.practicos.Covid19.model.Sintoma;
import com.practicos.Covid19.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class SintomaImpl implements Repository<Sintoma, String> {
    private List<Sintoma> sintomaList;

    public SintomaImpl() {
        this.sintomaList = new ArrayList<>();

        this.initializeSintomas();
    }

    private void initializeSintomas() {
        sintomaList.add(new Sintoma("A1", "Fiebre", "Alto"));
        sintomaList.add(new Sintoma("A2", "Tos", "Bajo"));
        sintomaList.add(new Sintoma("A3", "Dolor de cabeza", "Bajo"));
        sintomaList.add(new Sintoma("A4", "Fatiga", "Moderado"));
        sintomaList.add(new Sintoma("A5", "Dolor de garganta", "Bajo"));
    }

    public Sintoma findByName(String name){
        return this.sintomaList.stream().filter(sintoma -> sintoma.getNombre().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Sintoma> findAll() {
        return this.sintomaList;
    }

    @Override
    public Sintoma find(String id) {
        return this.sintomaList.stream().filter(sintoma -> sintoma.getCodigo().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void delete(String id) {
        this.sintomaList.removeIf(sintoma -> sintoma.getCodigo().equals(id));
    }

    @Override
    public void add(Sintoma obj) {
        this.sintomaList.add(obj);
    }
}
