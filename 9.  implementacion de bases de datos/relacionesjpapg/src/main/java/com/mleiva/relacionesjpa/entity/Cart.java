package com.mleiva.relacionesjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // Relacion uno a muchos con la clase Item
    @OneToMany(mappedBy = "cart") // mappedBy es usado para definir el lado de referencia de la relacion
    private Set<Item> items; // usamos Set porque no agrega el mismo objeto dos veces a la seleccion
}
