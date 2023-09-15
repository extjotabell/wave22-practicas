package com.concesionariaDeAutos.concesionariaDeAutos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
    private String date;
    private int kilometers;
    private String description;
}
