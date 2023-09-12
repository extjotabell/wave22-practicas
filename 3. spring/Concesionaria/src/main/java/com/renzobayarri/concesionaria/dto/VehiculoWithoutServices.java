package com.renzobayarri.concesionaria.dto;

import com.renzobayarri.concesionaria.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoWithoutServices {

    private String brand;

    private String model;

    private LocalDate manufacturingDate;

    private int numberOfKilometers;

    private int doors;

    private double price;

    private String currency;

    private int countOfOwners;
}
