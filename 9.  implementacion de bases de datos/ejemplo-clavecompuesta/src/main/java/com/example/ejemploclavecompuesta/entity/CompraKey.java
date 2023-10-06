package com.example.ejemploclavecompuesta.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CompraKey implements Serializable {

    private Integer id;
    private LocalDate fecha;

}
