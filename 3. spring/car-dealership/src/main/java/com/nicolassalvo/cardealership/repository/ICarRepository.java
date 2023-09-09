package com.nicolassalvo.cardealership.repository;

import com.nicolassalvo.cardealership.entity.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> getAllCars();

    Car addCar(Car car);
    Car getCarById(int id);
}
