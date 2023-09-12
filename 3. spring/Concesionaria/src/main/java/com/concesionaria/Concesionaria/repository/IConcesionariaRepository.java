package com.concesionaria.Concesionaria.repository;

import com.concesionaria.Concesionaria.entity.Car;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaRepository {
    Car saveCar(Car car);
    List<Car> getAll();
    List<Car> findByDate(LocalDate since, LocalDate to);
    List<Car> findByPrice(String since, String to);
    Car findById(int id);
}
