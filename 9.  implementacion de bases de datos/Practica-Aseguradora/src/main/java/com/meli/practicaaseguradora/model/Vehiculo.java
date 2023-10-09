package com.meli.practicaaseguradora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private  String modelo;
    private String matricula;

    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;
    private Integer cantRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = false)
    private List<Siniestro> siniestros;

}
