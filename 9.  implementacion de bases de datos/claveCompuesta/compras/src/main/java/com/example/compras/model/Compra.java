package com.example.compras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@IdClass(CompraId.class) // Anotación para indicar una clave compuesta
@Table(name = "compras")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compra implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Id
    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "monto")
    private double monto;
}
