package com.example.empresaseguros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Setter
@Getter
@Table(name = "Vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vehiculo;

    private String patente;
    private String marca;
    private String modelo;
    private LocalDate añoFabricacion;
    private int cantidadRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehiculo")
    private List<Siniestro> siniestros;


}
