package com.example.ropa.entity;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Clothes")
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;
    private Integer amount;
    private Double precioVenta;

}
