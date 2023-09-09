package com.nicolassalvo.cardealership.service;

import com.nicolassalvo.cardealership.dto.CarDTO;
import com.nicolassalvo.cardealership.dto.FullCarDTO;
import com.nicolassalvo.cardealership.entity.Car;
import com.nicolassalvo.cardealership.exception.CarNotFoundException;
import com.nicolassalvo.cardealership.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService implements ICarService{
    @Autowired
    ICarRepository carRepository;
    @Override
    public List<CarDTO> getAllVehicles() {
        List<Car> cars = carRepository.getAllCars();
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : cars) {
            carDTOList.add(new CarDTO(
                    car.getId(),
                    car.getBrand(),
                    car.getModel(),
                    car.getManufacturingDate(),
                    car.getDoor(),
                    car.getPrice(),
                    car.getCurrency(),
                    car.getCountOfOwners()
            ));
        }

        return carDTOList;
    }

    @Override
    public FullCarDTO createCar(FullCarDTO car) {
        Car newCar = new Car(car.getId(), car.getBrand(), car.getModel(), car.getManufacturingDate(), car.getDoor(), car.getPrice(), car.getCurrency(), car.getServices(),car.getCountOfOwners());
        carRepository.addCar(newCar);
        return car;
    }

    @Override
    public List<CarDTO> findCarsByDate(LocalDate since) {
        List<Car> cars = carRepository.getAllCars().stream().filter(car -> car.getManufacturingDate().isAfter(since.minusDays(1))).toList();
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : cars) {
            carDTOList.add(new CarDTO(
                    car.getId(),
                    car.getBrand(),
                    car.getModel(),
                    car.getManufacturingDate(),
                    car.getDoor(),
                    car.getPrice(),
                    car.getCurrency(),
                    car.getCountOfOwners()
            ));
        }
        return carDTOList;
    }

    @Override
    public List<CarDTO> findCarsByPrice(double since) {
        List<Car> cars = carRepository.getAllCars().stream().filter(car -> car.getPrice() >= since).toList();
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : cars) {
            carDTOList.add(new CarDTO(
                    car.getId(),
                    car.getBrand(),
                    car.getModel(),
                    car.getManufacturingDate(),
                    car.getDoor(),
                    car.getPrice(),
                    car.getCurrency(),
                    car.getCountOfOwners()
            ));
        }
        return carDTOList;
    }

    @Override
    public FullCarDTO getVehicleById(int id) {
        Car foundCar = carRepository.getCarById(id);
        if (foundCar == null) {
            throw new CarNotFoundException(id);
        }
        return new FullCarDTO(
                foundCar.getId(),
                foundCar.getBrand(),
                foundCar.getModel(),
                foundCar.getManufacturingDate(),
                foundCar.getDoor(),
                foundCar.getPrice(),
                foundCar.getCurrency(),
                foundCar.getServices(),
                foundCar.getCountOfOwners()
        );
    }
}
