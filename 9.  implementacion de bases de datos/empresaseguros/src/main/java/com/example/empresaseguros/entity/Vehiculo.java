package com.example.empresaseguros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Setter
@Getter
@Data
@Table(name = "Vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vehiculo;

    private String patente;
    private String marca;
    private String modelo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate añoFabricacion;
    private int cantidadRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehiculo")
    private List<Siniestro> siniestros;


}
