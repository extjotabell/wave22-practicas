package com.example.ejercicioconcesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Service {

    private Date date;
    private int kilometers;
    private String description;

}
