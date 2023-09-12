package com.renzobayarri.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    private int id;

    private String brand;

    private String model;

    private LocalDate manufacturingDate;

    private int numberOfKilometers;

    private int doors;

    private double price;

    private String currency;

    private List<Services> services;

    private int countOfOwners;
}
