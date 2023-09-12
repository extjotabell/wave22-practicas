package com.example.concesionariaautos.repository;

import com.example.concesionariaautos.dto.CarServiceDto;
import com.example.concesionariaautos.entity.Car;

import java.util.List;

public interface ICarRepository {
    void createCar(CarServiceDto car);
    List<Car> getAllCars();
    List<Car> getAllUsedCars();
    List<Car> getCarDate(Integer since, Integer to);
    List<Car> getCarPrice(Integer since, Integer to);
    Car getById(Integer id);

}
