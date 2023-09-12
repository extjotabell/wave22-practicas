package com.ejercicios.concesionaria.service;

import com.ejercicios.concesionaria.dto.VehiclesDTO;
import com.ejercicios.concesionaria.dto.VehiclesDTOS;


import java.time.LocalDate;
import java.util.List;

public interface IService {

    Integer save(VehiclesDTOS vechiclesDTOS);
    List<VehiclesDTO> getAll();
    List<VehiclesDTOS> getDates(LocalDate startDate, LocalDate endDate);
    List<VehiclesDTOS> getPrices(Double minPrice, Double maxPrice);
    VehiclesDTOS findById(Integer id);

}
