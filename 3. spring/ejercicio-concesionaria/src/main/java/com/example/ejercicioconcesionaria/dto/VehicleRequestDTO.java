package com.example.ejercicioconcesionaria.dto;

import com.example.ejercicioconcesionaria.model.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleRequestDTO {

    private int id;
    private String brand;
    private String model;
    private String  manufacturingDate;
    private int doors;
    private int price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

}