package com.example.concesionariaautos.dto;

import com.example.concesionariaautos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer kms;
    private Integer doors;
    private Integer price;
    private String currency;
    private Integer ownerCount;
}