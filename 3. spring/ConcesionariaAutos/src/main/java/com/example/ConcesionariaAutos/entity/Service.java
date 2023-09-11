package com.example.ConcesionariaAutos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}
