package com.example.ejerciciopersonajessw.repository;

import com.example.ejerciciopersonajessw.entity.Caracter;

import java.util.List;

public interface ICaracaterRepository {
    List<Caracter> searchByName(String name);
}
