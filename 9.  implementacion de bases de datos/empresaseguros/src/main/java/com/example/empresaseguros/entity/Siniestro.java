package com.example.empresaseguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_siniestro;

    private LocalDate fecha;
    private Double perdidaEconomica;
}
