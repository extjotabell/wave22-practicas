package com.ejercicios.concesionaria.repository;

import com.ejercicios.concesionaria.entity.Vehicles;

import java.time.LocalDate;
import java.util.List;

public interface IRepository {

    Integer save(Vehicles vechicles);
    List<Vehicles> getAll();
    List<Vehicles> getDates(LocalDate startDate, LocalDate enDate);
    List<Vehicles> getPrices(Double minPrice, Double maxPrice);
    Vehicles findById(Integer id);
}
