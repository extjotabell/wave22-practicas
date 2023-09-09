package com.spring.consecionariadeautos.services.impl;

import com.spring.consecionariadeautos.entities.Car;
import com.spring.consecionariadeautos.exceptions.CarNotFoundException;
import com.spring.consecionariadeautos.exceptions.IdAlreadyTakenException;
import com.spring.consecionariadeautos.repositories.ICarRepository;
import com.spring.consecionariadeautos.services.ICarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CarServiceImpl implements ICarService {

    private final ICarRepository iCarRepository;

    @Override
    public void addCar(Car car) {
        ensureUniqueId(car.getId());
        iCarRepository.add(car);
    }

    @Override
    public List<Car> findAllCars() {
        return iCarRepository.findAll();
    }

    @Override
    public List<Car> findCarsByDate(LocalDate date) {
        List<Car> carsFounded = iCarRepository.findByDate(date);
        if(carsFounded == null) {
            throw new CarNotFoundException();
        }
        return carsFounded;
    }

    @Override
    public List<Car> findCarsByPrice(Double price, Double secondPrice) {
        List<Car> carsFounded = iCarRepository.findByPrice(price, secondPrice);
        if(carsFounded == null) {
            throw new CarNotFoundException();
        }
        return carsFounded;
    }

    @Override
    public Car getCar(Long id) {
        Car carFounded = iCarRepository.get(id);
        if (carFounded == null) {
            throw new CarNotFoundException(id);
        }
        return carFounded;
    }

    private void ensureUniqueId(Long id) {
        for (Car c : findAllCars()) {
            if(Objects.equals(c.getId(), id)) {
                throw new IdAlreadyTakenException(id);
            }
        }
    }

}