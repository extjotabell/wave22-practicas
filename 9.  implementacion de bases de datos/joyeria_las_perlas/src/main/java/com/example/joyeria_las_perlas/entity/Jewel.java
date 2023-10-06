package com.example.joyeria_las_perlas.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Where(clause = "venta_o_no=true")
public class Jewel {
    @Id
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta_o_no")
    private Boolean ventaONo;
}
