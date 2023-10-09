package com.mleiva.relacionesjpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Relacion uno a uno con user
    @OneToOne(mappedBy = "address") // mappedBy se usa para indicar que la variable "address" del lado de la clase User es quien establece la relacion
    private User user;
}
