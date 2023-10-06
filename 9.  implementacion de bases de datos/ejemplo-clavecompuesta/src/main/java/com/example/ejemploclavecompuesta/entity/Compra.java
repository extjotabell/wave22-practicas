package com.example.ejemploclavecompuesta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="compras")
@IdClass(value=CompraKey.class)
@AllArgsConstructor
public class Compra {

    @Id
    private Integer id;
    @Id
    private LocalDate fecha;
    private String descripcion;

}

