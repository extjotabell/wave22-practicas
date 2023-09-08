package com.nicolassalvo.cardealership.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarDTO {
    private String brand;
    private String model;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private int door;
    private double price;
    private String currency;
    private int countOfOwners;
}
