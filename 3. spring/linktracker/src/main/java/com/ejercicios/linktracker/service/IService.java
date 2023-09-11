package com.ejercicios.linktracker.service;

import com.ejercicios.linktracker.dto.LinkDTO;

import java.util.HashMap;

public interface IService <T,E>{
    E save(LinkDTO link);
    HashMap<E,T> getAll();
    T getById(E id);
    void delete(E id);

     String findUrlById(Integer id);
     void countRedirect (T link);

     void invalidarLink (T link);

     boolean validarPassword(LinkDTO link, String Password);
}
