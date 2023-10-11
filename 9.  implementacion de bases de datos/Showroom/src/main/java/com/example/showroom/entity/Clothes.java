package com.example.showroom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clothes")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private int amount;
    private double price;
}
