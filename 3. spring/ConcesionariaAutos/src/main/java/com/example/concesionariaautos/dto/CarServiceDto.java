package com.example.concesionariaautos.dto;

import com.example.concesionariaautos.entity.Service;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class CarServiceDto extends CarDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numerOfKilometes;
    private int prince;
    private List<Service> serviceList;
}