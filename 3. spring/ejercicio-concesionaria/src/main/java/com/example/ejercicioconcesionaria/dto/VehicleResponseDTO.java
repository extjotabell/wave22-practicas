package com.example.ejercicioconcesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleResponseDTO {

    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private int doors;
    private int price;
    private String currency;
    private int countOfOwners;
}
