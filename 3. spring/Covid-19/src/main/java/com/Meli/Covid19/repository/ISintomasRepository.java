package com.Meli.Covid19.repository;

import com.Meli.Covid19.model.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ISintomasRepository {

    void save(Sintoma sintoma);
    List<Sintoma> getAll();
    Optional<Sintoma> getByName(String nombre);

}
