package com.example.concesionariaautos.repository;

import com.example.concesionariaautos.dto.CarServiceDto;
import com.example.concesionariaautos.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository implements ICarRepository {
    private List<Car> cars = new ArrayList<>();

    @Override
    public void createCar(CarServiceDto carDto) {
        this.cars.add(
                new Car(this.cars.size() +1,
                        carDto.getBrand(),
                        carDto.getModel(),
                        carDto.getManufacturingDate(),
                        carDto.getKms(),
                        carDto.getDoors(),
                        carDto.getPrince(),
                        carDto.getCurrency(),
                        carDto.getServices(),
                        carDto.getOwnerCount()));
    }
;
    @Override
    public List<Car> getAllCars() {
        return this.cars;
    }

    @Override
    public List<Car> getAllUsedCars() {
        return  this.cars.stream().filter(car -> car.getOwnerCount() > 0).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarDate(Integer since, Integer to) {
       return this.cars.stream().filter(x -> Integer.parseInt(x.getManufacturingDate().substring(0,4)) >= since && Integer.parseInt(x.getManufacturingDate().substring(0,4)) <= to).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarPrice(Integer since, Integer to) {
        return this.cars.stream().filter(x-> x.getPrice() >= since && x.getPrice() <= to ).collect(Collectors.toList());
    }

    @Override
    public Car getById(Integer id) {
        return this.cars.stream().filter(x-> x.getId() == id ).findFirst().get();
    }


}
