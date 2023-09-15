package com.concesionariaDeAutos.concesionariaDeAutos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleWoServicesDto {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
