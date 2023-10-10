package com.movies.demoHQL.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vehiculos")
public class Vehiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String modelo;
    private String marca;
    private Integer cantRuedas;
    private Integer fabricacion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="idVehiculoDenunciado")
    private List<Siniestro> siniestros;

    public Vehiculo(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

    public Vehiculo(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }
}
