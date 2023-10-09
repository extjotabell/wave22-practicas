package com.example.ejerciciopracticogrupal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fecha;

    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
}
