package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.CarDto;
import com.example.concesionariaautos.dto.CarServiceDto;

import java.util.List;

public interface ICarService {

    void createCar(CarServiceDto carDto);
    List<CarDto> getAllCars();
    List<CarServiceDto> getCarDate(Integer since, Integer to);
    List<CarServiceDto> getCarPrice(Integer since, Integer to);
    CarServiceDto getById(Integer id);

}
