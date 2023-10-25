package com.example.empresaseguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Siniestro> siniestros;

    public void addSiniestro(Siniestro siniestro) {
        this.siniestros.add(siniestro);
        siniestro.setVehiculo(this);
    }

    public void removeSiniestro(Siniestro siniestro) {
        this.siniestros.remove(siniestro);
        siniestro.setVehiculo(null);
    }

    public Vehiculo(String patente) {
        this.patente = patente;
    }
}
