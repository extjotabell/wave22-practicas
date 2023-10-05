package com.renzobayarri.joyerialaperlacrud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "joyas")
@Getter
@Setter
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long id;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    private Boolean ventaONo;

}
