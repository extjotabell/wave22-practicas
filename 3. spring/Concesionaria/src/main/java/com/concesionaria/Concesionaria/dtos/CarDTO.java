package com.concesionaria.Concesionaria.dtos;

import com.concesionaria.Concesionaria.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    List<Services> services;
    private String countOfOwners;
}
