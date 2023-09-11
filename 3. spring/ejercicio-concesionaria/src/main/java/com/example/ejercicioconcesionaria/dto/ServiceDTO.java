package com.example.ejercicioconcesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceDTO {

    private String date;
    private int kilometers;
    private String description;

}
