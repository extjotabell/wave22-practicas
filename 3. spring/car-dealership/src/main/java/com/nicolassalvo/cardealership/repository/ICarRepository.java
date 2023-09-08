package com.nicolassalvo.cardealership.repository;

import com.nicolassalvo.cardealership.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> getAllCars();
}
