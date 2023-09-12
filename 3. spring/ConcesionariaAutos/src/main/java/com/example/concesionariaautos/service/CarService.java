package com.example.concesionariaautos.service;

import com.example.concesionariaautos.repository.CarRepository;
import com.example.concesionariaautos.repository.ICarRepository;
import com.example.concesionariaautos.dto.CarDto;
import com.example.concesionariaautos.dto.CarServiceDto;
import com.example.concesionariaautos.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {

    @Autowired
    CarRepository repository;

    @Override
    public void createCar(CarServiceDto carDto) {
        repository.createCar(carDto);
    }

    @Override
    public List<CarDto> getAllCars() {
        return repository.getAllUsedCars()
                .stream()
                .map(x -> new CarDto(
                x.getBrand(),
                x.getModel(),
                x.getManufacturingDate(),
                x.getKms(),
                x.getDoors(),
                x.getPrice(),
                x.getCurrency(),
                x.getOwnerCount())
        ).collect(Collectors.toList());
    }

    @Override
    public List<CarServiceDto> getCarDate(Integer since, Integer to) {
        return mapToDTO(repository.getCarDate(since,to));
    }

    @Override
    public List<CarServiceDto> getCarPrice(Integer since, Integer to) {
        return mapToDTO(repository.getCarPrice(since,to));
    }

    @Override
    public CarServiceDto getById(Integer id) {
        List<Car> carList = new ArrayList<>();
        carList.add(repository.getById(id));
        return mapToDTO(carList).get(0);
    }

    private List<CarServiceDto> mapToDTO(List<Car> carList) {
        return carList.stream()
                .map(x->
                new CarServiceDto(x.getBrand(),
                x.getModel(),
                x.getManufacturingDate(),
                x.getKms(),
                x.getDoors(),
                x.getPrice(),
                x.getCurrency(),
                x.getServices(),
                x.getOwnerCount()))
                .collect(Collectors.toList());
    }
}
