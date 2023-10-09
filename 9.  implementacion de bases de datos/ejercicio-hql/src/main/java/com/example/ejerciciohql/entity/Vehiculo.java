package com.example.ejerciciohql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="vehiculos")
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer ruedas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="siniestro_id")
    private List<Siniestro> siniestros;

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public Vehiculo(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }
}
