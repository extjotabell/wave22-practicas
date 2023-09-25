package com.ejercicios.concesionaria.repository;

import java.time.LocalDate;
import java.util.List;

public interface IRepository <T, E> {
    void save(T obj);
    List<T> getAll();
    T getById(E id);
    List<T> getByDate(LocalDate since, LocalDate to);
    List<T> getByPrice(Double since, Double to);
}
