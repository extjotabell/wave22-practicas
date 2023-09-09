package com.nicolassalvo.cardealership.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Service {
    private LocalDate date;
    private double kilometers;
    private String description;
}
