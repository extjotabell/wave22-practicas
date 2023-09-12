package com.example.concesionaria.service;


import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.dto.AutoServiceDTO;
import com.example.concesionaria.repository.IAutoRepository;

import java.time.LocalDate;
import java.util.List;

public interface IAutoService {
    AutoServiceDTO createCar(AutoServiceDTO autoServiceDTO);
    List<AutoDTO> getCars();

    List<AutoDTO> getCarsByDateSince(String date,String to);
    List<AutoDTO> getCarsByPrice(double price, double to);

    AutoServiceDTO getCarById(int id);
}
