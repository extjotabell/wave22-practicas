package com.nicolassalvo.cardealership.repository;

import com.nicolassalvo.cardealership.model.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements ICarRepository{
    List<Car> cars;

    public CarRepository() {
        init();
    }
    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    private void init() {
        cars = new ArrayList<>();
        cars.add(new Car("Marca1", "Modelo1", LocalDate.of(2020, 3, 22), 5, 188000, "AR", 1));
        cars.add(new Car("Marca2", "Modelo2", LocalDate.of(2022, 5, 12), 4, 195000, "AR", 1));
        cars.add(new Car("Marca1", "Modelo3", LocalDate.of(2005, 10, 24), 5, 87000, "AR", 2));
    }
}
