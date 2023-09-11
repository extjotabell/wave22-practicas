package com.ejercicios.linktracker.repository;

import com.ejercicios.linktracker.entity.Link;

import java.util.HashMap;

public interface IRepository <T,E> {
    E save(Link link);
    HashMap<E,T> getAll();
    T getById(E id);
    void delete(E id);

}
