package com.bootcamp.lasperlas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "joyas")
public class Joya {
    @Id
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    private Boolean venta;
}
