package com.mleiva.relacionesjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // Asociada con la variable de clase cart. Muchos items asociados a 1 carrito.
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}