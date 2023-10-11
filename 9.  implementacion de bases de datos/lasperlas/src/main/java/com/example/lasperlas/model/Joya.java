package com.example.lasperlas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE joya SET ventaono = false WHERE id=?")
@Where(clause = "ventaono=true")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo = Boolean.TRUE;
}
