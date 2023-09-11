package com.concesionaria.Concesionaria.service;

import com.concesionaria.Concesionaria.dtos.CarDTO;
import com.concesionaria.Concesionaria.dtos.CarNoServicesDTO;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaService {
    CarDTO saveCar(CarDTO car);
    List<CarNoServicesDTO> getAll();
    List<CarDTO> findByDate(LocalDate date);
    List<CarDTO> findByPrice(String price);
    CarDTO findById(int id);
}
