package com.example.concesionaria.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auto {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int door;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}

/*{
    "brand": "Chevrolet",
    "model": "Corsa",
    "manufacturingDate": "2000-11-20",
    "door": 5,
    "price": 90000,
    "currency": "AR",
    "services": [
    {
    "date": "2003-05-20",
    "kilometers": 60000,
    "description": "change air filters"
    }
    ],
    "countOfOwners": 2
}*/