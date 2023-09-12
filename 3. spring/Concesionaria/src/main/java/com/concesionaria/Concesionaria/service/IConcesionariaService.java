package com.concesionaria.Concesionaria.service;

import com.concesionaria.Concesionaria.dtos.CarDTO;
import com.concesionaria.Concesionaria.dtos.CarNoServicesDTO;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaService {
    void saveCar(CarDTO car);
    List<CarNoServicesDTO> getAll();
    List<CarDTO> findByDate(LocalDate since, LocalDate to);
    List<CarDTO> findByPrice(String since, String to);
    CarDTO findById(int id);
}
