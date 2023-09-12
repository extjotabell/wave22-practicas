package com.spring.consecionariadeautos.services;

import com.spring.consecionariadeautos.entities.Car;

import java.time.LocalDate;
import java.util.List;

public interface ICarService {
    void addCar(Car car);
    List<Car> findAllCars();
    List<Car> findCarsByDate(LocalDate date);
    List<Car> findCarsByPrice(Double price, Double secondPrice);
    Car getCar(Long id);
}
