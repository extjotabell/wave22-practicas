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
    private Integer id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer kms;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Integer ownerCount;

}
