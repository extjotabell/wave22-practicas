package com.nicolassalvo.cardealership.service;

import com.nicolassalvo.cardealership.dto.CarDTO;

import java.util.List;

public interface ICarService {
    List<CarDTO> getAllVehicles();
}
