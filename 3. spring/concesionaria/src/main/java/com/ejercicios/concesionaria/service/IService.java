package com.ejercicios.concesionaria.service;

import java.time.LocalDate;
import java.util.List;

public interface IService <T, S, E> {
    void save(S obj);
    List<T> getAll();
    T getById(E id);
    List<T> getByDate(LocalDate since, LocalDate to);
    List<T> getByPrice(Double since, Double to);
}
