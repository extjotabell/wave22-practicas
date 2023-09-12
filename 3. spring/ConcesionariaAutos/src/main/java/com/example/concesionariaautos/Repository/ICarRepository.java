package com.example.concesionariaautos.Repository;

import com.example.concesionariaautos.dto.CarServiceDto;
import com.example.concesionariaautos.entity.Car;

import java.util.List;

public interface ICarRepository {
    void CreateCar(CarServiceDto car);
    List<Car> AllCar();
    List<Car> GetCarDate(String since );
    List<Car> GetCarPrice(int since, int to);
    Car GetById(int id);

}
