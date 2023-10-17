package com.example.automotriz.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fecha;
    private double perdidaEconomica;
    private Long idVehiculoDenunciado;

    @ManyToOne
    @JoinColumn(name = "vehiculo_denunciante_id", nullable = false)
    private Vehiculo vehiculoDenunciante;
}
