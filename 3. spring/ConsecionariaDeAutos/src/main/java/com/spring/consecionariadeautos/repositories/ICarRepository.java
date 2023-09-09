package com.spring.consecionariadeautos.repositories;

import com.spring.consecionariadeautos.entities.Car;

import java.time.LocalDate;
import java.util.List;

public interface ICarRepository {
    void add(Car car);
    List<Car> findAll();
    List<Car> findByDate(LocalDate date);
    List<Car> findByPrice(Double price, Double secondPrice);
    Car get(Long id);
}
