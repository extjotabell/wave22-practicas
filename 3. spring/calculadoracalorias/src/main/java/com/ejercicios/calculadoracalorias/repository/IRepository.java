package com.ejercicios.calculadoracalorias.repository;

import com.ejercicios.calculadoracalorias.model.Food;

import java.util.List;

public interface IRepository<T, E> {
    public List<T> findAll();
    public T find(E id);
    public void delete(E id);
    public void add(T obj);
}
