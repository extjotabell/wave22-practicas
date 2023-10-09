package com.example.empresaseguros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_siniestro;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;
    private Double perdidaEconomica;
}
