package com.Meli.Covid19.repository;

import com.Meli.Covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SintomasRepository implements ISintomasRepository{

    final List<Sintoma> repositorioSintomas = new ArrayList<Sintoma>();

    @Override
    public void save(Sintoma sintoma) {
        repositorioSintomas.add(sintoma);
    }

    @Override
    public List<Sintoma> getAll() {
        return repositorioSintomas;
    }

    @Override
    public Optional<Sintoma> getByName(String nombre) {
        return repositorioSintomas.stream().filter( sintoma -> sintoma.getNombre().equals(nombre)).findFirst();
    }
}
