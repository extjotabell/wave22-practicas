package com.example.concesionaria.dto;

import com.example.concesionaria.entity.Service;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutoServiceDTO {
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
