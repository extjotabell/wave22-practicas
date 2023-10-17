package com.meli.joyeria.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
