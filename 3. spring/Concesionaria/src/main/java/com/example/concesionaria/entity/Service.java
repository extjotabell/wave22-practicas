package com.example.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private String date;
    private Double kilometers;
    private String descriptions;
}
