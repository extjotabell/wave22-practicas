package com.example.showroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ropa")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prendaId;

    private String nombre;

    private String tipo;

    private String marca;

    private String color;

    private String talle;

    private Integer cantidad;

    private Double precioVenta;
}


