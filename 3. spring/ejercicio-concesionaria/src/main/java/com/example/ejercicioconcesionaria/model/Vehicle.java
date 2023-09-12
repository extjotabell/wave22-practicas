package com.example.ejercicioconcesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {

    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int doors;
    private int price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

}
