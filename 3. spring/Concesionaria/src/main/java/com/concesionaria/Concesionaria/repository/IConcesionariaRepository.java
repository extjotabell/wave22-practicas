package com.concesionaria.Concesionaria.repository;

import com.concesionaria.Concesionaria.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaRepository {
    Car saveCar(Car car);
    List<Car> getAll();
    List<Car> findByDate(LocalDate date);
    List<Car> findByPrice(String price);
    Car findById(int id);
}
