package com.example.concesionariaautos.dto;

import com.example.concesionariaautos.entity.Service;
import lombok.*;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class CarServiceDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer kms;
    private Integer doors;
    private Integer prince;
    private String currency;
    private List<Service> services;
    private Integer ownerCount;
}