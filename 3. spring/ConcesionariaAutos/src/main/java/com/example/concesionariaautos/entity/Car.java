package com.example.concesionariaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private int numberOfKilometes;
    private int doors;
    private int price;
    private String currency;
    private List<Service> serviceList;
    private int countOfOwners;

}
