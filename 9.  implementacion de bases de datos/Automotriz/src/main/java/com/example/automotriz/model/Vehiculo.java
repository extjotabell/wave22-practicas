package com.example.automotriz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate anioDeFabricacion;
    private int cantidadDeRuedas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoDenunciante")
    private List<Siniestro> siniestros;

}
