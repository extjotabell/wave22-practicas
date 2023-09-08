package com.nicolassalvo.cardealership.service;

import com.nicolassalvo.cardealership.dto.CarDTO;
import com.nicolassalvo.cardealership.model.Car;
import com.nicolassalvo.cardealership.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
