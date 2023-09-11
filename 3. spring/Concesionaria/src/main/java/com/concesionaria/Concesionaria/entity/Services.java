package com.concesionaria.Concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
