package com.example.concesionaria.service;


import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.dto.AutoServiceDTO;
import com.example.concesionaria.repository.IAutoRepository;

import java.time.LocalDate;
import java.util.List;

public interface IAutoService {
    AutoServiceDTO createCar(AutoServiceDTO autoServiceDTO);
    List<AutoDTO> getCars();

    List<AutoDTO> getCarsByDateSince(String date);
    List<AutoDTO> getCarsByPrice(double price);

    AutoServiceDTO getCarById(int id);
}
