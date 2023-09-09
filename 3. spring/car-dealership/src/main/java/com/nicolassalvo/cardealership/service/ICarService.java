package com.nicolassalvo.cardealership.service;

import com.nicolassalvo.cardealership.dto.CarDTO;
import com.nicolassalvo.cardealership.dto.FullCarDTO;

import java.time.LocalDate;
import java.util.List;

public interface ICarService {
    List<CarDTO> getAllVehicles();
    FullCarDTO createCar(FullCarDTO car);
    List<CarDTO> findCarsByDate(LocalDate since);
    List<CarDTO> findCarsByPrice(double since);
    FullCarDTO getVehicleById(int id);
}
