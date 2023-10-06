package com.example.lasperlas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; // Es necesario que no sea un tipo primitivo porque es un ID y
                    //  el generic de JpaRepository no puede tener un tipo primitivo.
    private String nombre;
    private String material;
    private long peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    @JsonProperty("en_venta")
    private boolean enVenta;
}
