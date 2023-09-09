package com.nicolassalvo.cardealership.repository;

import com.nicolassalvo.cardealership.entity.Car;
import com.nicolassalvo.cardealership.entity.Service;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements ICarRepository{
    private List<Car> cars;
    private int carId = 1;

    public CarRepository() {
        init();
    }
    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Car addCar(Car car) {
        car.setId(++carId);
        cars.add(car);
        return car;
    }

    private void init() {
        cars = new ArrayList<>();
        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service(LocalDate.of(2021,4,5), 10000, "General"));
        cars.add(new Car(carId, "Marca1", "Modelo1", LocalDate.of(2020, 3, 22), 5, 188000, "AR", services,1));
        cars.add(new Car(++carId, "Marca2", "Modelo2", LocalDate.of(2022, 5, 12), 4, 195000, "AR",  new ArrayList<>(),1));
        services.remove(0);
        services.add(new Service(LocalDate.of(2006,6,12), 10000, "General"));
        services.add(new Service(LocalDate.of(2007,6,7), 25765, "General"));
        cars.add(new Car(++carId, "Marca1", "Modelo3", LocalDate.of(2005, 10, 24), 5, 87000, "AR", services,2));
    }
}
