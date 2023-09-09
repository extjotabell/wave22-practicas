package com.nicolassalvo.cardealership.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Car {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int door;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

    public void setId(int id) {
        this.id = id;
    }
}
