package com.spring.consecionariadeautos.web.dto;

import com.spring.consecionariadeautos.entities.ServiceCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarServicesDTO {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<ServiceCar> serviceCars;
    private Integer countsOfOwners;
}
