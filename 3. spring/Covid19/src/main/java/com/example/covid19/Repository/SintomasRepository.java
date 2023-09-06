package com.example.covid19.Repository;

import com.example.covid19.Model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomasRepository implements Repository<Sintoma, String> {
    private List<Sintoma> sintomaList;

    public SintomasRepository() {
        this.sintomaList = new ArrayList<>();

        this.initializeSintomas();
    }

    private void initializeSintomas() {
        sintomaList.add(new Sintoma("S1", "Fiebre", "Moderado"));
        sintomaList.add(new Sintoma("S2", "Tos", "Leve"));
        sintomaList.add(new Sintoma("S3", "Dolor de cabeza", "Moderado"));
        sintomaList.add(new Sintoma("S4", "Fatiga", "Severo"));
        sintomaList.add(new Sintoma("S5", "Dolor de garganta", "Leve"));
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
