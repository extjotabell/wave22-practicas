package com.movies.demoHQL.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "vehiculos")
public class Vehiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patente;
    private String modelo;
    private String marca;
    private Integer cantRuedas;
    private Integer fabricacion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="siniestros")
    private Set <Siniestro>  siniestros;

}
