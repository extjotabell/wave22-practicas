package com.example.concesionaria.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutoDTO {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int door;
    private double price;
    private String currency;
    private int countOfOwners;
}
