package com.concesionaria.Concesionaria.repository;

import com.concesionaria.Concesionaria.dtos.CarDTO;
import com.concesionaria.Concesionaria.dtos.CarNoServicesDTO;
import com.concesionaria.Concesionaria.entity.Car;
import com.concesionaria.Concesionaria.exceptions.CarsNotFound;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcesionariaRepository implements IConcesionariaRepository{

    private List<Car> cars = new ArrayList<>();

    @Override
    public Car saveCar(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public List<Car> findByDate(LocalDate date) {
        List<Car> carsByDate = cars.stream().filter(c-> c.getManufacturingDate().equals(date)).toList();
        return carsByDate;
    }

    @Override
    public List<Car> findByPrice(String price) {
        List<Car> carsByPrice = cars.stream().filter(c-> c.getPrice().equals(price)).toList();
        return carsByPrice;
    }

    @Override
    public Car findById(int id) {
        Car carById = cars.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        return carById;
    }
}
